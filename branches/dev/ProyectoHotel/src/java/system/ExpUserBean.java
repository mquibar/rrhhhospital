/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import DTO.DtoUsuario;
import Entidades.seguridad.Perfil;
import Entidades.seguridad.Usuario;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioPerfil;
import Intermediarios.IntermediarioUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpUserBean implements ExpNewUser {

    public List<Perfil> iniciarNewUser() {
        return (new IntermediarioPerfil()).findAll();
    }

    public boolean newUser(String nombre, String password, Perfil... perfiles) {
        if (!userNameIsValue(nombre)) {
            return false;
        }
        if (!passwordIsValue(password)) {
            return false;
        }
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setPassword(Tools.Encriptador.getStringMessageDigest(password, Tools.Encriptador.MD5));
        usuario.setEliminado(false);
        usuario.setPerfiles(new ArrayList<Perfil>());
        for (Perfil perfil : perfiles) {
            usuario.getPerfiles().add(perfil);
        }
        boolean guardado= false;
        try {
            GestorConeccion.getInstance().beginTransaction();
            if( (new IntermediarioUsuario()).guardar(usuario) ){
                GestorConeccion.getInstance().commitTransaction();
                guardado = true;
            }
            else{
                GestorConeccion.getInstance().rollbackTransaction();
                guardado=false;
            }
        } catch (Exception e) {
            return false;
        }
        return guardado;
    }

    private boolean userNameIsValue(String nombre) {

        if (nombre == null || nombre.length() == 0) {
            return false;
        }

        DtoUsuario dto = new DtoUsuario();
        dto.setNombre(nombre);
        Usuario user = null;
        try {
            user = (new IntermediarioUsuario()).findByDto(dto).get(0);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private boolean passwordIsValue(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }
        return true;
    }
}
