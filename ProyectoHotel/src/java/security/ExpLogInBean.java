/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import DTO.DtoUsuario;
import Entidades.seguridad.Usuario;
import Intermediarios.IntermediarioUsuario;
import Tools.Encriptador;
import javax.ejb.Stateless;
import system.exception.InvalidDataException;
import system.exception.SystemException;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpLogInBean implements ExpLogIn {
    
    public void logIn(String userName, String password) throws SystemException{
        DtoUsuario dto = new DtoUsuario();
        dto.setNombre(userName);

        Usuario user=null;
        try{user= (Usuario) (new IntermediarioUsuario()).findByDto(dto).get(0);}catch(Exception e){System.out.println("Erro al buscar " + e.getMessage());}
        if(user==null){
            throw new InvalidDataException("usuario", userName);
        }

        password = Encriptador.getStringMessageDigest(password,"MD5");
        String pass = Encriptador.getStringMessageDigest(user.getPassword(),"MD5");

        if(!pass.equals(password))
            throw new InvalidDataException("password", "password incorrecto");
        //ExpSeguridad.getInstance().setUser(user);
        
    }

    public void logOff() {
        ExpSeguridad.getInstance().logOff();
    }
 
}
