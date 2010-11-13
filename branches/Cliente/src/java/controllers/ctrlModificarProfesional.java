/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.personal.ExpModificarProfesional;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionProfesional;

/**
 *
 * @author MARIANO
 */

public class ctrlModificarProfesional extends GeneralController{

    private ExpModificarProfesional _exp;
    private ModelOptionProfesional model = null;

    public ctrlModificarProfesional() {
        _exp = (ExpModificarProfesional) super.getExpert(ExpModificarProfesional.class.getName());
    }

    public AbstractModelOptionList getProfesionales(){
        if(model ==null)
            model = new ModelOptionProfesional(_exp.listarProfesional());
        return model;
    }
    
    



}
