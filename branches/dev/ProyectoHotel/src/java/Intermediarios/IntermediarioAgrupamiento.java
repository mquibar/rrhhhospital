/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import javax.ejb.Remote;

/**
 *
 * @author desarrollo
 */
@Remote
public interface IntermediarioAgrupamiento<E> extends Intermediario<E>{

    public E findByName(String nombre);
}
