/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import Entidades.seguridad.Perfil;
import java.util.List;
import javax.ejb.Remote;
import system.exception.SystemException;

/**
 *
 * @author Manuel
 */
@Remote
public interface ExpNewUser {
    public List<Perfil> listarPerfil();
    public void newUser(String nombre, String password, Perfil... perfiles)throws SystemException;
    
}
