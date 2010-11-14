/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Pais;
import Expertos.personal.ExpConsultarDomicilio;
import java.util.List;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionLocalidad;
import models.combos.ModelOptionPais;
import models.combos.ModelOptionProvincia;

/**
 *
 * @author MARIANO
 */
public class ctrlConsultarDomicilio extends GeneralController {

    private ExpConsultarDomicilio _exp;
    private ModelOptionPais model = null;
    private ModelOptionProvincia modelprovincia = null;
    private ModelOptionLocalidad modellocalidad = null;

    public ctrlConsultarDomicilio() {
        _exp = (ExpConsultarDomicilio) super.getExpert(ExpConsultarDomicilio.class.getName());
    }

    public AbstractModelOptionList getPaises(){
        if(model == null)
            model = new ModelOptionPais(_exp.consultarTodosPaises());
        return model;
    }

    public AbstractModelOptionList getProvincia () {
        if(modelprovincia == null)
            modelprovincia = new ModelOptionProvincia(_exp.consultarTodasProvincias());
        return modelprovincia;
    }

     public AbstractModelOptionList getLocalidades(String value){
        if(modelprovincia == null) getProvincia();
        try{
            return new ModelOptionLocalidad(_exp.consultarLocalidadesProvincia(modelprovincia.getSelectedItem(Integer.valueOf(value))));
        }catch(Exception ex){
            return new ModelOptionLocalidad(null);
        }
    }

}
