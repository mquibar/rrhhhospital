/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Familia
 */
@Remote
public interface IntermediarioCategoria<E> extends Intermediario<E> {

    public List<E> finAllInOrder(String order);

    @Override
    public List<E> findByDto(Object dto);
}
