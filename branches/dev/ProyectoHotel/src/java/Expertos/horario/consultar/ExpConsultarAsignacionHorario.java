/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario.consultar;

import Entidades.AsignacionHorario;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
public interface  ExpConsultarAsignacionHorario {

    public List<AsignacionHorario> listar();
}
