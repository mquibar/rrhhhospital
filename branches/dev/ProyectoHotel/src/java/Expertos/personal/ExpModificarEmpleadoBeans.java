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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */

@Stateless
public class ExpModificarEmpleadoBeans implements ExpModificarEmpleado {

    public ExpModificarEmpleadoBeans() {
    }
    
    public Map<String, List> listarEmpleados(){
        Map<String,List> lista = new HashMap<String, List>();
        lista.put("EMPLEADO", (new Intermediarios.IntermediarioEmpleado()).findAll());
        lista.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        lista.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        lista.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return lista;
    }
    
    public boolean modificarEmpleado (Empleado empleado, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo sexo, String cuil) {
        
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setDni(dni);
            empleado.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));
            empleado.setTelefono(Long.getLong(telefono));
            empleado.setIdSexo(sexo);
            empleado.setCuil(cuil);
            empleado = modificarDomicilioEmpleado(empleado, barrio, calle,
                     numero, piso, departamanto, localidad, provincia, pais);

            return new Intermediarios.IntermediarioEmpleado().actualizar(empleado);
    }

    private Empleado modificarDomicilioEmpleado (Empleado empleado, String barrio,
            String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais){

            empleado.getIdDomicilio().setCalle(calle);
            empleado.getIdDomicilio().setBarrio(barrio);
            empleado.getIdDomicilio().setNumero(Integer.getInteger(numero));
            empleado.getIdDomicilio().setPiso(piso);
            empleado.getIdDomicilio().setDepartamento(departamanto);
            empleado.getIdDomicilio().setIdLocalidad(localidad);
            empleado.getIdDomicilio().setIdProvincia(provincia);
            empleado.setIdPais(pais);

        return empleado;
    
    }

}
