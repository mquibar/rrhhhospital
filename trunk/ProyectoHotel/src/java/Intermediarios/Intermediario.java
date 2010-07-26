/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import java.util.List;


/**
 *
 * @author desarrollo
 */
public interface Intermediario{

    public List<Object> findAll();
    public boolean guardar(Object obj);
    public boolean actualizar(Object obj);
    public List<Object> findByDto(Object dto);
    public List<Object> finAllInOrder(String order);

}
