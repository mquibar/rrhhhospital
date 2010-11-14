/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.AsignacionHorario;
import Expertos.horario.ExpConsultarAsignacionHorario;
import Intermediarios.IntermediarioAsignacionHorario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarAsignacionHorarioBeans implements ExpConsultarAsignacionHorario {


    public List<AsignacionHorario> listar() {
        return (new IntermediarioAsignacionHorario()).findAll();
    }

    public AsignacionHorario consultarAsignacionHorarioPorId(int id) {
        return (new IntermediarioAsignacionHorario().findById(id));
    }
}
