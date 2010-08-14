/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import java.util.List;
import javax.ejb.Remote;


/**
 *
 * @author desarrollo
 */
@Remote
public interface Intermediario<E>{

    public List<E> findAll();
    public boolean guardar(E obj);
    public boolean actualizar(E obj);
    public List<E> findByDto(Object dto);

}
