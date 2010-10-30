/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Sexo;
import Expertos.ExpertoConsultarSexo;
import Intermediarios.IntermediarioSexo;

/**
 *
 * @author MARIANO
 */
public class ExpConsultarSexoBeans implements ExpertoConsultarSexo {

    public Sexo listarSexo (String sexo) {
        return ( new IntermediarioSexo().findBySexo(sexo));
    }
}
