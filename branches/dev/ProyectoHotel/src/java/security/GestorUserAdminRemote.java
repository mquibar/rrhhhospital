/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface GestorUserAdminRemote {

    public java.util.List<Entidades.seguridad.Usuario> listarUsuarios();
    
}
