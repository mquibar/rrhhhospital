/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system;

import DTO.DtoUsuario;
import Entidades.seguridad.Usuario;
import Intermediarios.IntermediarioUsuario;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpLogInBean implements ExpLogInRemote {
    
    public boolean logIn(String userName, String password){
        DtoUsuario dto = new DtoUsuario();
        dto.setNombre(userName);
        Usuario user = (Usuario) (new IntermediarioUsuario()).findByDto(dto);
        if(user==null)
            return false;
        if(user.getPassword().equals(Tools.Encriptador.getStringMessageDigest(password,"MD5")))
            return true;
        else
            return false;
    }
 
}
