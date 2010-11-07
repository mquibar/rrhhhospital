/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Sexo;
import Expertos.ExpConsultarSexo;
import Intermediarios.IntermediarioSexo;
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
}
