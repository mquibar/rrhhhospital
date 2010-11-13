/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Empleado;
import java.util.Date;

/**
 *
 * @author Manuel
 */
public interface  ExpAltaRegistroPeriodo {

    public String guardar ();
    public void iniciarAlta (
            String idEntidad,
            Empleado empleado,
            Date fechaEntrada,
            Date horaEntrada,
            Date fechaSalida,
            Date horaSalida,
            Boolean vigente
            );

}
