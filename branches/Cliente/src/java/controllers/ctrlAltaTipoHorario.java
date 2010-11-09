/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.ExpAltaAsignacionHorario;
import Expertos.ExpAltaTipoHorario;
import Expertos.ExpConsultarPersonal;
import Expertos.ExpConsultarTipoHorario;
import Tools.ManejaFechas;
import models.combos.ModelOptionProfesional;
import models.combos.ModelOptionTipoHorario;

/**
 *
 * @author leoroot
 */
public class ctrlAltaTipoHorario extends GeneralController
{
    ExpAltaTipoHorario _expAlta;

    public ctrlAltaTipoHorario()
    {
        try
        {
            _expAlta = (ExpAltaTipoHorario) super.getExpert(ExpAltaTipoHorario.class.getName());
        }
        catch(Exception ex)
        {
            System.out.println("Error: No se pudo instanciar el experto: " + ex.getMessage());
        }
    }

    public void iniciarAlta(
            String nombre,
            String descripcion,
            String horaEntrada,
            String horaSalida,
            String vigente
            )
    {
         _expAlta.iniciarAlta(
             nombre,
             descripcion,
             ManejaFechas.convertirString(horaEntrada),
             ManejaFechas.convertirString(horaSalida)
             );
    }

    public String guardar() {return _expAlta.guardar();}
    
}
