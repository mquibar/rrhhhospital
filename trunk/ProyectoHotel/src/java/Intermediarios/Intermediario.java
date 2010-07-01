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
public interface Intermediario{

    public void beginTransaction();
    public void commitTransaction();
    public void rollbackTransaction();

}
