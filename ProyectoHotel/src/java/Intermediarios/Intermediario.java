/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;


/**
 *
 * @author desarrollo
 */
public interface Intermediario{

    public void beginTransaction();
    public void commitTransaction();
    public void rollbackTransaction();

}
