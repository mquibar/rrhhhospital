/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.TipoHorario;
import Expertos.horario.ExpConsultarTipoHorario;
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

    public TipoHorario consultarTipoHorarioPorNombre(String nombre) {
        return (new IntermediarioTipoHorario().findByNombre(nombre));
    }

}
