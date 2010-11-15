/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Empleado;
import Entidades.RegistroPeriodo;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
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

    public RegistroPeriodo getEntidad(String idEntidad);

}
