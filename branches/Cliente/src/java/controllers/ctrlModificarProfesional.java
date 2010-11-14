/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Domicilio;
import Expertos.personal.ExpConsultarDomicilio;
import Expertos.personal.ExpConsultarPersonal;
import Expertos.personal.ExpModificarProfesional;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionProfesional;

/**
 *
 * @author MARIANO
 */

public class ctrlModificarProfesional extends GeneralController{

    private ExpModificarProfesional _exp;
    private ExpConsultarDomicilio _expdomicilio;
    private ModelOptionProfesional model = null;
    private ExpConsultarPersonal _expcons;

    public ctrlModificarProfesional() {
        _exp = (ExpModificarProfesional) super.getExpert(ExpModificarProfesional.class.getName());
    }

    public AbstractModelOptionList getProfesionales(){
        if(model ==null)
            model = new ModelOptionProfesional(_exp.listarProfesional().get("PROFESIONAL"));
            //model = new ModelOptionProfesional(_expcons.listarProfesionalinOrder());
        return model;
    }

    public String recuperarDato (String valor) {

        return "nombre="+model.getSelectedItem(valor).getNombre()+"&"+
               "apellido="+model.getSelectedItem(valor).getApellido()+"&"+
               "dni="+model.getSelectedItem(valor).getDni()+"&"+
               "fechaNacimiento="+Tools.ManejaFechas.convertirDate(model.getSelectedItem(valor).getFechaIngreso())+"&"+
               "telefono="+Long.toString(model.getSelectedItem(valor).getTelefono())+"&"+
               "matricula="+model.getSelectedItem(valor).getMatricula()+"&"+
               "cuil="+model.getSelectedItem(valor).getCuil()+"&"+
               "calle="+model.getSelectedItem(valor).getIdDomicilio().getCalle();

        //recupararDomicilio(model.getSelectedItem(valor).getIdDomicilio().getId())

    }

    private String recupararDomicilio (int id) {
        Domicilio domicilio = _expdomicilio.consultaDomicilioporId(id);
        return "calle="+domicilio.getCalle()+"&"+
               "numero="+domicilio.getNumero()+"&"+
               "barrio="+domicilio.getBarrio()+"&"+
               "piso="+domicilio.getPiso()+"&"+
               "departamento="+domicilio.getDepartamento();
               
    }
   
}
