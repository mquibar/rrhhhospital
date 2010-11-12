/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Empleado;
import Entidades.TipoLicencia;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface  ExpAltaLicencia {

    public String guardar();
    public void iniciarAlta (
            Empleado Empleado,
            TipoLicencia TipoLicencia,
            Date FechaInicio,
            Date FechaFin,
            String motivo
            );

}
