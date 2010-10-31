/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.Beans.ExpAltaAsignacionHorarioBeans;
import Expertos.ExpAltaAsignacionHorario;

/**
 *
 * @author leoroot
 */
public class crtlAltaAsignacionHorario
{
    ExpAltaAsignacionHorario _exp = new ExpAltaAsignacionHorarioBeans();

    public void iniciarAlta(
            String fechaInicio,
            String fechaFin,
            String idEmpleado,
            String idTipoHorario,
            String descripcion,
            String vigente
            )
    {
        
    }

    //public String guardar() {return _exp.guardar();}


}
