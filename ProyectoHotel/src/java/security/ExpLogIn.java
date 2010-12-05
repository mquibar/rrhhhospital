/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import javax.ejb.Remote;
import system.exception.SystemException;

/**
 *
 * @author Manuel
 */
@Remote
public interface ExpLogIn {
     public Entidades.seguridad.Usuario logIn(String user, String Password) throws SystemException;

     public void logOff();
}
