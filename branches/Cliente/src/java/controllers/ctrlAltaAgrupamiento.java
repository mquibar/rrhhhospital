/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.ExpAltaAgrupamiento;

/**
 *
 * @author Manuel
 */
public class ctrlAltaAgrupamiento {

    private GeneralController _controladorGeneral;

    public ctrlAltaAgrupamiento(GeneralController controladorGeneral) {
        this._controladorGeneral = controladorGeneral;
    }

    public String guardarAgrupamiento(String nombre){
        String mensaje="javascript:alert('";
        try{
            Expertos.ExpAltaAgrupamiento exp = (ExpAltaAgrupamiento) _controladorGeneral.getExpert(Expertos.ExpAltaAgrupamiento.class.getName());
            if(exp.guardarNuevo(nombre))
                mensaje += "Agrupamiento Guardado Con Exito";
            else
                mensaje += "Error Para Guardar el Agrupamiento Ingresado";
        }catch(Exception ex){
            mensaje += "Ocurrio un error al realizar la operacion \n";
            mensaje += ex.getMessage();
        }
        mensaje += "');return false";

        return mensaje;
    }



}
