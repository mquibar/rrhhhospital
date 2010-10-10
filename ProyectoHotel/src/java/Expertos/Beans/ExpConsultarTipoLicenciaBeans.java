/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.TipoLicencia;
import Expertos.ExpConsultarTipoLicencia;
import Intermediarios.IntermediarioTipoLicencia;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarTipoLicenciaBeans implements ExpConsultarTipoLicencia {


    public List<TipoLicencia> listar() {
        return (new IntermediarioTipoLicencia()).findAll();
    }

}
