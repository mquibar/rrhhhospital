/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import DTO.DtoEmpleado;
import DTO.DTOProfesional;
import Entidades.Empleado;
import Entidades.Profesional;
import Expertos.personal.ExpConsultarPersonal;
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

    public Empleado consultarEmpleadoPorDNI(String dni) {
        return (new IntermediarioEmpleado().findByDni(dni));
    }

    public Profesional consultarProfesionalPorDNI(String dni) {
        return (new IntermediarioProfesional().findByDni(dni));
    }

    public Profesional consultarProfesionalPorMatricula(String matricula) {
        return (new IntermediarioProfesional().findByDni(matricula));
    }

    public Empleado consultarEmpleadoPorCuil(String cuil) {
        return (new IntermediarioProfesional().findByDni(cuil));
    }

}
