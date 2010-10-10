/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import DTO.DtoEmpleado;
import DTO.DTOProfesional;
import Entidades.Empleado;
import Entidades.Profesional;
import Expertos.ExpConsultarPersonal;
import Intermediarios.IntermediarioEmpleado;
import Intermediarios.IntermediarioProfesional;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */
@Stateless
public class ExpConsultarPersonalBeans implements ExpConsultarPersonal {

    public List<Empleado> listarEmpleadoinOrder() {
        return (new IntermediarioEmpleado().findInOrden("apellido"));
    }

    public List<Profesional> listarProfesionalinOrder() {
        return (new IntermediarioProfesional().findInOrden("apellido"));
    }

    public List<Empleado> consultarEmpleadoPorNombreyApellido(String nombre, String apellido) {
        IntermediarioEmpleado intermediario = new IntermediarioEmpleado();
        List<Empleado> empleado;
        DtoEmpleado dto = new DtoEmpleado();
        dto.setApellido(apellido);
        dto.setNombre(nombre);
        try {
            empleado = intermediario.findByDto(dto);
        } catch (NullPointerException e) {
            empleado=null;
        }
        dto=null;
        intermediario=null;
        return empleado;
    }

    public List<Profesional> consultarProfesionalPorNombreyApellido(String nombre, String apellido) {
        IntermediarioProfesional intermediario = new IntermediarioProfesional();
        List<Profesional> profesional;
        DTOProfesional dto = new DTOProfesional();
        dto.setApellido(apellido);
        dto.setNombre(nombre);
        try {
            profesional = intermediario.findByDto(dto);
        } catch (NullPointerException e) {
            profesional=null;
        }
        dto=null;
        intermediario=null;
        return profesional;
    }

    /*Implementar con findByDni de la Entidad Empleado*/
    public Empleado consultarEmpleadoPorDNI(String dni) {
        return (new IntermediarioEmpleado().findInOrden("dni").get(0));
    }

    /*Implementar con findByDni de la Entidad Profesional*/
    public Profesional consultarProfesionalPorDNI(String dni) {
        return (new IntermediarioProfesional().findInOrden("dni").get(0));
    }

    /*Implementar con findByMatricula de la Entidad Profesional*/
    public Profesional consultarProfesionalPorMatricula(String matricula) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*Implementar con findByCuil de la Entidad Empleado*/
    public Empleado consultarEmpleadoPorCuil(String cuil) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
