/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import Expertos.categorizacion.ExpModificarAgrupamiento;
import Expertos.personal.ExpAltaEmpleado;
import controllers.GeneralController;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionAgrupamiento;
import models.combos.ModelOptionTipoEmpleado;
import models.combos.ModelOptionTramo;

/**
 *
 * @author Manuel
 */
public class testController extends GeneralController {

    ExpModificarAgrupamiento _exp;
    ExpAltaEmpleado _expemple;
    ModelOptionAgrupamiento agrup=null;
    ModelOptionTipoEmpleado emple=null;

    public testController() {
        _exp = (ExpModificarAgrupamiento) super.getExpert(ExpModificarAgrupamiento.class.getName());
    }

    public AbstractModelOptionList getAgrupamientos(){
        if(agrup ==null)
            agrup = new ModelOptionAgrupamiento(_exp.inicioModificacion());
        return agrup;
    }

    public AbstractModelOptionList getTramo(String value){
        if(agrup == null) getAgrupamientos();
        try{
            Thread.sleep(2000);
            return new ModelOptionTramo(_exp.consultarTramos(agrup.getSelectedItem(Integer.valueOf(value))));
        }catch(Exception ex){
            return new ModelOptionTramo(null);
        }
    }

}
