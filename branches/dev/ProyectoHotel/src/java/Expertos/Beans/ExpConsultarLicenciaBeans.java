/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Licencia;
import Expertos.ExpConsultarLicencia;
import Intermediarios.IntermediarioLicencia;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarLicenciaBeans implements ExpConsultarLicencia {


    public List<Licencia> listar() {
        return (new IntermediarioLicencia()).findAll();
    }

}
