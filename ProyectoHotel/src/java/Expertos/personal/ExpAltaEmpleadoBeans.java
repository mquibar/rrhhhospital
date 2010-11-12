/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Empleado;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import Entidades.Sexo;
import Entidades.Tarjeta;
import Entidades.TipoEmpleado;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioEmpleado;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */

@Stateless
public class ExpAltaEmpleadoBeans implements ExpAltaEmpleado {

    private Empleado _empleado;

    public ExpAltaEmpleadoBeans() {
        _empleado = new Empleado();
    }

    public void agregarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Map<String, List> iniciarEmpleado(){
        Map<String,List> listas = new HashMap<String, List>();
        listas.put("TIPO", (new Intermediarios.IntermediarioTipoEmpleado()).findAll());
        listas.put("TARJETA", (new Intermediarios.IntermediarioTarjeta()).findAll());
        listas.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        listas.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        listas.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return listas;
    }

    public boolean iniciarAlta(TipoEmpleado tipo,String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo sexo, String cuil, Tarjeta tarjeta) {
            boolean resultado;

            _empleado.setNombre(nombre);
            _empleado.setApellido(apellido);
            _empleado.setDni(dni);
            _empleado.setFechaNacimiento(fechaNacimiento);
            _empleado.setTelefono(telefono);
            agregarDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia, pais);
            _empleado.setIdSexo(sexo);
            _empleado.setCuil(cuil);
            _empleado.setFechaIngreso(new Date());
            _empleado.setIdTipoEmpleado(tipo);
            _empleado.setIdTarjeta(tarjeta);
            
            GestorConeccion.getInstance().beginTransaction();
            try{
                if( (new IntermediarioEmpleado()).guardar(_empleado) ){
                    resultado = true;
                    GestorConeccion.getInstance().commitTransaction();
                }
                else{
                    resultado = false;
                    GestorConeccion.getInstance().rollbackTransaction();
                }
            }catch(Exception ex){
                System.out.println("************ <Error en el Experto de Alta de Persona>");
                ex.printStackTrace();
                System.out.println("<\\Error> *****************");
                resultado = false;
            }
            return resultado;
    }

    public boolean agregarLegajo(Empleado empleado, int legajo) {
        empleado.setLegajo(legajo);
        return (new IntermediarioEmpleado()).actualizar(empleado);
    }

    private void agregarDomicilio (String barrio, String calle, String numero,
            String piso, String departamanto, Localidad localidad, Provincia provincia, Pais pais) {

        _empleado.setIdDomicilio((new ExpAltaDomicilioBeans()).altaDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia));
        _empleado.setIdPais(pais);

    }

}
