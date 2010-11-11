/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.horario.ExpAltaTipoHorario;
import Tools.ManejaFechas;

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
             ManejaFechas.getHour(horaEntrada),
             ManejaFechas.getHour(horaSalida)
             );
    }

    public String guardar() {return _expAlta.guardar();}
    
}
