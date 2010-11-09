/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

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
            Date fechaInicio,
            Date fechaFin,
            Empleado idEmpleado,
            TipoHorario idTipoHorario,
            String descripcion,
            boolean vigente
            );

    public String guardar();

}
