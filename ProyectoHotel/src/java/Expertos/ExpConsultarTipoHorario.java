/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.TipoHorario;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
@Local
public interface  ExpConsultarTipoHorario {

    public List<TipoHorario> listar();
}