/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import DTO.DtoUsuario;
import Entidades.seguridad.Usuario;
import Intermediarios.IntermediarioUsuario;
import javax.ejb.Stateless;
import system.exception.InvalidDataException;
import system.exception.SystemException;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpLogInBean implements ExpLogInRemote {
    
    public void logIn(String userName, String password) throws SystemException{
        DtoUsuario dto = new DtoUsuario();
        dto.setNombre(userName);
        Usuario user = (Usuario) (new IntermediarioUsuario()).findByDto(dto);
        if(user==null)
            throw new InvalidDataException("usuario", userName);

        password = Tools.Encriptador.getStringMessageDigest(password,"MD5");
        String pass = Tools.Encriptador.getStringMessageDigest(user.getPassword(),"MD5");

        if(!pass.equals(password))
            throw new InvalidDataException("password", "password incorrecto");
        ExpSeguridad.getInstance().setUser(user);
        
    }
 
}