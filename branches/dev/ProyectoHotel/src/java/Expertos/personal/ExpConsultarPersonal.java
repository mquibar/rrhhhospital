/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Empleado;
import Entidades.Profesional;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author MARIANO
 */
@Remote
public interface ExpConsultarPersonal {

    public List<Empleado> listarEmpleadoinOrder();

    public List<Profesional> listarProfesionalinOrder();

    public List<Empleado> consultarEmpleadoPorNombreyApellido(String nombre, String apellido);

    public List<Profesional> consultarProfesionalPorNombreyApellido(String nombre, String apellido);

    public Empleado consultarEmpleadoPorDNI(String dni);

    public Profesional consultarProfesionalPorDNI(String dni);

    public Profesional consultarProfesionalPorMatricula(String matricula);

    public Empleado consultarEmpleadoPorCuil(String cuil);
}
