/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Profesional;
import Entidades.Provincia;
import Entidades.Sexo;
import Entidades.Tarjeta;
import Entidades.TipoEmpleado;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioProfesional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */

@Stateless
public class ExpAltaProfesionalBeans implements ExpAltaProfesional {

    private Profesional _profesional;

    public ExpAltaProfesionalBeans() {
        _profesional = new Profesional();
        
    }

    public Map<String, List> iniciarProfesional(){
        Map<String,List> listas = new HashMap<String, List>();
        listas.put("TIPO", (new Intermediarios.IntermediarioTipoEmpleado()).findAll());
        listas.put("TARJETA", (new Intermediarios.IntermediarioTarjeta()).findAll());
        listas.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        listas.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        listas.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return listas;
    }

    public void agregarProfesional(Profesional profesional) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean iniciarAlta(TipoEmpleado tipo, String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso,
            String departamanto, Localidad localidad, Provincia provincia, Pais pais, Sexo sexo,
            String cuil, String matricula, String titulo, Tarjeta tarjeta) {
        boolean resultado;
       
        _profesional.setNombre(nombre);
        _profesional.setApellido(apellido);
        _profesional.setDni(dni);
        _profesional.setFechaNacimiento(fechaNacimiento);
        _profesional.setTelefono(telefono);
        agregarDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia, pais);
        _profesional.setIdSexo(sexo);
        _profesional.setCuil(cuil);
        _profesional.setMatricula(matricula);
        _profesional.setTitulo(titulo);
        _profesional.setFechaIngreso(new Date());
        _profesional.setIdTipoEmpleado(tipo);
        _profesional.setIdTarjeta(tarjeta);

         GestorConeccion.getInstance().beginTransaction();
        try{
            if( (new IntermediarioProfesional()).guardar(_profesional) ){
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

    //Agrega el domicilio del profesional
    public void agregarDomicilio (String barrio, String calle, String numero,
            String piso, String departamanto, Localidad localidad, Provincia provincia, Pais pais) {

        _profesional.setIdDomicilio((new ExpAltaDomicilioBeans()).altaDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia));
        _profesional.setIdPais(pais);

    }

    public boolean iniciarAlta(String nombre, String apellido, String dni,
            Date fechaNacimiento, long telefono, String barrio, String calle,
            String numero, String piso, String departamanto, Localidad localidad,
            Provincia provincia, Pais pais, Sexo sexo, String cuil, String matricula,
            String titulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
