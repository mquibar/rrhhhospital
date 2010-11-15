/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Empleado;
import Expertos.personal.ExpBajaEmpleado;
import Expertos.personal.ExpConsultarPersonal;
import java.util.List;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionEmpleado;

/**
 *
 * @author MARIANO
 */
public class ctrlBajaPersonal extends GeneralController {

    private ExpBajaEmpleado _exp;
    private ExpConsultarPersonal _expcons;
    private ModelOptionEmpleado model=null;

    /*Genera un Controlador de Baja personal para administrar las bajas*/
    public ctrlBajaPersonal() {
        _exp = (ExpBajaEmpleado) getExpert(ExpBajaEmpleado.class.getName());
        _expcons = (ExpConsultarPersonal) getExpert(ExpConsultarPersonal.class.getName());
    }

    /*Carga todos los empleados del Hospital*/
    public AbstractModelOptionList getEmpleados () {
        try {
            model = new ModelOptionEmpleado(_expcons.listarEmpleadoinOrder());
        }
        catch (Exception e){
            System.out.println("exepcion controlador"+e.toString());
        }
        return model;

    }

    /*Recupera los datos del empleado seleccionado para una previsualizacion */
    public String recuperarDato (String valor) {

        return "Nombre: "+model.getSelectedItem(valor).getNombre()+"\n"+
               "Apellido: "+model.getSelectedItem(valor).getApellido()+"\n"+
               "DNI: "+model.getSelectedItem(valor).getDni()+"\n"+
               "Fecha de Nacimiento: "+Tools.ManejaFechas.convertirDate(model.getSelectedItem(valor).getFechaIngreso())+"\n"+
               "Telefono: "+Long.toString(model.getSelectedItem(valor).getTelefono())+"\n"+
               "Legajo: "+Integer.toString(model.getSelectedItem(valor).getLegajo())+"\n"+
               "Cuil: "+model.getSelectedItem(valor).getCuil()+"\n"+
               "Calle: "+model.getSelectedItem(valor).getIdDomicilio().getCalle()+"\n"+
               "Numero: "+model.getSelectedItem(valor).getIdDomicilio().getNumero()+"\n"+
               "Barrio: "+model.getSelectedItem(valor).getIdDomicilio().getBarrio()+"\n"+
               "Piso: "+model.getSelectedItem(valor).getIdDomicilio().getPiso()+"\n"+
               "Departamento: "+model.getSelectedItem(valor).getIdDomicilio().getDepartamento();

    }

    /*Da de Baja a un Empleado*/
    public String darBaja (String valor) {
        if (_exp.darBajaEmpleado(model.getSelectedItem(valor)))
            return "Empleado de Baja"+model.getSelectedItem(valor).getApellido();
        else
            return "error";
    }
    
}
