/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Clase;
import Entidades.RegistroPeriodo;
import Entidades.Tramo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Manuel
 */
public interface  ExpAltaRegistroPeriodo {

    public void agregarRegistroPeriodo (RegistroPeriodo registroPeriodo);
    public void iniciarAlta (
            Date fechaEntrada,
            Date horaEntrada,
            Date fechaSalida,
            Date horaSalida,
            int idEmpleado
            );

}
