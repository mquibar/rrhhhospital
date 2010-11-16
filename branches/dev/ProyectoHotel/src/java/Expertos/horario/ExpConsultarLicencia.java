/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Licencia;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
public interface  ExpConsultarLicencia {

    public List<Licencia> listar();
}
