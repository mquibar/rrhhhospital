/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Empleado;
import Entidades.Licencia;
import java.util.Date;

/**
 *
 * @author Manuel
 */
public interface  ExpAltaLicencia {

    public void agregarLicencia (Licencia licencia);
    public void iniciarAlta (
            Empleado idEmpleado,
            int idTipoLicencia,
            Date FechaInicio,
            Date FechaFin,
            String motivo
            );

}
