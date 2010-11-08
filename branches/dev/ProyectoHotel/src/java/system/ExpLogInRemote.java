/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system;

import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface ExpLogInRemote {
    public boolean logIn(String user, String Password);
}
