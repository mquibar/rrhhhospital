/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.TipoHorario;
import javax.ejb.Remote;
import java.util.Date;

/**
 *
 * @author Manuel
 */
@Remote
public interface  ExpAltaTipoHorario {

    public void agregarTipoHorario (TipoHorario tipoHorario);
    public void iniciarAlta (
            String nombre,
            String descripcion,
            Date horaIngreso,
            Date horaSalida
            );

    public String guardar();

}
