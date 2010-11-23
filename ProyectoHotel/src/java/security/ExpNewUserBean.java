/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import DTO.DtoUsuario;
import Entidades.seguridad.Perfil;
import Entidades.seguridad.Usuario;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioPerfil;
import Intermediarios.IntermediarioUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import system.exception.DuplicateKeyException;
import system.exception.GenericException;
import system.exception.InvalidDataException;
import system.exception.SystemException;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpNewUserBean implements ExpNewUser {

    public List<Perfil> listarPerfil() {
        return (new IntermediarioPerfil()).findAll();
    }

    public void newUser(String nombre, String password, Perfil... perfiles) throws SystemException {
        userNameVerify(nombre);
        passwordVerify(password);
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setPassword(Tools.Encriptador.getStringMessageDigest(password,"MD5"));
        usuario.setEliminado(false);
        usuario.setPerfiles(new ArrayList<Perfil>());
        for (Perfil perfil : perfiles) {
            usuario.getPerfiles().add(perfil);
        }
        try {
            GestorConeccion.getInstance().beginTransaction();
            if( (new IntermediarioUsuario()).guardar(usuario) ){
                GestorConeccion.getInstance().commitTransaction();
            }
            else{
                GestorConeccion.getInstance().rollbackTransaction();
                throw new Exception("No se pudo guardar el objeto");
            }
        } catch (Exception e) {
            throw new GenericException("Error al guardar: "+e.getMessage());
        }
    }

    private void userNameVerify(String nombre) throws InvalidDataException, DuplicateKeyException{

        if (nombre == null || nombre.length() == 0) {
            throw new InvalidDataException("usuario", "dato no ingresado");
        }

        DtoUsuario dto = new DtoUsuario();
        dto.setNombre(nombre);
        Usuario user = null;
        try {
            user = (new IntermediarioUsuario()).findByDto(dto).get(0);
            throw new DuplicateKeyException("usuario", nombre);
        } catch (Exception e) {
        }
    }

    private void passwordVerify(String password) throws InvalidDataException {
        if (password == null || password.length() == 0) {
            throw new InvalidDataException("password", "password invalido");
        }
    }
}
