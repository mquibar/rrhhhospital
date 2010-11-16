/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.AsignacionHorario;
import Entidades.Empleado;
import Entidades.TipoHorario;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface  ExpAltaAsignacionHorario {

    public void agregarAsignacionHorario (AsignacionHorario asignacionHorario);
    public void iniciarAlta (
            String idEntidad,
            Date fechaInicio,
            Date fechaFin,
            Empleado idEmpleado,
            TipoHorario idTipoHorario,
            String descripcion,
            boolean eliminado
            );

    public String guardar();

}
