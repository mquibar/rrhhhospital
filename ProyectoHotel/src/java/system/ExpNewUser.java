/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system;

import Entidades.seguridad.Perfil;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface ExpNewUser {
    public List<Perfil> iniciarNewUser();
    public boolean newUser(String nombre, String password, Perfil... perfiles);
    
}
