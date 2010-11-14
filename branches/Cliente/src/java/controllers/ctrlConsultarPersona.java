/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Empleado;
import Entidades.Profesional;
import Expertos.personal.ExpConsultarPersonal;
import java.util.List;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionEmpleado;

/**
 *
 * @author MARIANO
 */
public class ctrlConsultarPersona extends GeneralController {

    private ExpConsultarPersonal _exp;
    private ModelOptionEmpleado model = null;

    public ctrlConsultarPersona() {
        _exp = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());
    }

    public List <Profesional> listarPersonal () {
        return _exp.listarProfesionalinOrder();
    }

    public List <Empleado> listarEmpleado () {
        return _exp.listarEmpleadoinOrder();
    }

    public AbstractModelOptionList consultarPorNombre (String nombre, String apellido) {
        try {
            model = new ModelOptionEmpleado( _exp.consultarEmpleadoPorNombreyApellido(nombre, apellido));
            //model = new ModelOptionProfesional(_expcons.listarProfesionalinOrder());
        }
        catch (Exception e){
            System.out.println("exepcion controlador"+e.toString());
        }
        return model;

    }

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



}
