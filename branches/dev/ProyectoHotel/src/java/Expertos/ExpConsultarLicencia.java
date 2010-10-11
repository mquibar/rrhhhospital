/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Licencia;
import Entidades.TipoLicencia;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
@Local
public interface  ExpConsultarLicencia {

    public List<Licencia> listar();
}
