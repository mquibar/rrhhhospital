/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import Entidades.Empleado;
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
    public List<Empleado> listarEmpleado();
    public List<Perfil> listarPerfil();
    public void newUser(Empleado empleado, String password, Perfil perfiles)throws SystemException;
    
}
