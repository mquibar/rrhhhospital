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
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Experto encargado de interactuar con la base de datos, para guardar el empleado en 
 * forma correcta
 *
 * @author Juan
 */

@Stateless
public class ExpAltaEmpleadoBeans implements ExpAltaEmpleado {

    @EJB
    private ExpConsultarPersonal _expConsulta;
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

    /**
     * Realiza la alta del empleado, con los datos que se le envian como parametro
     *
     * @param tipo
     * @param nombre
     * @param apellido
     * @param dni
     * @param fechaNacimiento
     * @param telefono
     * @param barrio
     * @param calle
     * @param numero
     * @param piso
     * @param departamanto
     * @param localidad
     * @param provincia
     * @param pais
     * @param sexo
     * @param cuil
     * @param tarjeta
     * @return: true si el empleado fue dado de alta
     */
    public boolean iniciarAlta(TipoEmpleado tipo,String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo sexo, String cuil, Tarjeta tarjeta) {
            boolean resultado;

            if (_expConsulta.consultarEmpleadoPorDNI(dni) != null)
                return false;

            _empleado.setNombre(nombre.toUpperCase());
            _empleado.setApellido(apellido.toUpperCase());
            _empleado.setDni(dni.toUpperCase());
            _empleado.setFechaNacimiento(fechaNacimiento);
            _empleado.setTelefono(telefono);
            agregarDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia, pais);
            _empleado.setIdSexo(sexo);
            _empleado.setCuil(cuil.toUpperCase());
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
                System.out.println("************ <Error en el Experto de Alta de Empleado>");
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
