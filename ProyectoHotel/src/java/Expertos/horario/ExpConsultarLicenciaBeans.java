/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Licencia;
import Expertos.horario.ExpConsultarLicencia;
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
