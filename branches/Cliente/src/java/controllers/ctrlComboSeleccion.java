/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

/**
 *
 * @author leoroot
 */
public class ctrlComboSeleccion
{
    static public String getCombo(String entidad)
    {
        String combo = "";
        
        if(entidad.equals("tipo_horario"))
        {
            combo = new ctrlAltaTipoHorario().getCombo();
        }
        else if(entidad.equals("asignacion_horario"))
        {
            combo = new ctrlAltaAsignacionHorario().getCombo();
        }
        else if(entidad.equals("registro_periodo"))
        {
            combo = new ctrlAltaRegistroPeriodo().getCombo();
        }
        else if(entidad.equals("licencia"))
        {
            combo = new ctrlAltaLicencia().getCombo();
        }

        return combo;
    }

}
