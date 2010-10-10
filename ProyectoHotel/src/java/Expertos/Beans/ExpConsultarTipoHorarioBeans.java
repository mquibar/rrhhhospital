/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.TipoHorario;
import Expertos.ExpConsultarTipoHorario;
import Intermediarios.IntermediarioTipoHorario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarTipoHorarioBeans implements ExpConsultarTipoHorario {


    public List<TipoHorario> listar() {
        return (new IntermediarioTipoHorario()).findAll();
    }

}
