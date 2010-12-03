/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import Entidades.seguridad.Usuario;
import Intermediarios.IntermediarioUsuario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class GestorUserAdminBean implements GestorUserAdminRemote{
    
    public List<Usuario> listarUsuarios(){
         return (new IntermediarioUsuario()).findAll();
    }
 
}
