/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import java.util.Date;

/**
 *
 * @author Manuel
 */
public interface  ExpAltaRegistroPeriodo {

    public String guardar ();
    public void iniciarAlta (
            Date fechaEntrada,
            Date horaEntrada,
            Date fechaSalida,
            Date horaSalida,
            int idEmpleado
            );

}
