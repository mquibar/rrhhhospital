/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Sexo;
import Expertos.personal.ExpConsultarSexo;
import Intermediarios.IntermediarioSexo;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */
@Stateless
public class ExpConsultarSexoBeans implements ExpConsultarSexo {

    public Sexo listarSexo (String sexo) {
        return ( new IntermediarioSexo().findBySexo(sexo));
    }

    public Sexo listarPorId (int id) {
        return ( new IntermediarioSexo().findById(id));
    }

    public List <Sexo> listAll () {
        return ( new IntermediarioSexo().findAll());
    }
}
