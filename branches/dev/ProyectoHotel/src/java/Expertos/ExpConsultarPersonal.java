/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

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

    public List<Empleado> listarEmpleado();
    public List<Profesional> listarProfesional();

}
