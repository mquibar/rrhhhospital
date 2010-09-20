/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface ExpAltaAgrupamiento {

    public boolean guardarNuevo(java.lang.String nombre);

}
