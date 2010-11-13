/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Empleado;
import Entidades.Profesional;
import Expertos.personal.ExpConsultarPersonal;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class ctrConsultarPersona extends GeneralController {

    private ExpConsultarPersonal _exp;

    public ctrConsultarPersona() {
        _exp = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());
    }

    public List <Profesional> listarPersonal () {
        return _exp.listarProfesionalinOrder();
    }

    public List <Empleado> listarEmpleado () {
        return _exp.listarEmpleadoinOrder();
    }

}
