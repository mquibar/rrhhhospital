/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Empleado;
import Entidades.Profesional;
import Expertos.ExpConsultarPersonal;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */
@Stateless
public class ExpConsultarPersonalBeans implements ExpConsultarPersonal {

    public List<Empleado> listarEmpleado() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Profesional> listarProfesional() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
