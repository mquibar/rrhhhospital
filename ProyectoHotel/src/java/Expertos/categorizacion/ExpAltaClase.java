/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.categorizacion;

import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
public interface ExpAltaClase {

    public boolean altaClase(String nombre);
}
