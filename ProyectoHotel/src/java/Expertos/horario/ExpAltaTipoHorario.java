/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.TipoHorario;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface  ExpAltaTipoHorario {

    public void agregarTipoHorario (TipoHorario tipoHorario);
    public void iniciarAlta (
            String idEntidad,
            String nombre,
            String descripcion,
            Date horaIngreso,
            Date horaSalida
            );

    public String guardar();

    public TipoHorario getEntidad(String idEntidad);


}
