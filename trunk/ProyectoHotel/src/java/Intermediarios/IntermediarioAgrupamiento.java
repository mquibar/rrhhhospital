/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Entidades.Agrupamiento;
import javax.ejb.Remote;

/**
 *
 * @author desarrollo
 */
@Remote
public interface IntermediarioAgrupamiento extends Intermediario{

    public Agrupamiento findByName(String nombre);
}
