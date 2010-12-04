/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import Entidades.seguridad.Usuario;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioUsuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import system.exception.GenericException;
import system.exception.InvalidDataException;

/**
 *
 * @author Manuel
 */
@Stateless
public class GestorUserAdminBean implements GestorUserAdminRemote {

    @EJB
    ExpSeguridad _exp;

    public List<Usuario> listarUsuarios() {
        return (new IntermediarioUsuario()).findAll();
    }

    public void modificarPass(Usuario user, String pass) throws InvalidDataException, GenericException {
        if (user == null) {
            throw new InvalidDataException("Usuario", "no asignado");
        }
        if (pass.isEmpty()) {
            throw new InvalidDataException("Password", "password vacio");
        }

        user.setPassword(Tools.Encriptador.getStringMessageDigest(pass, "MD5"));
        try {
            GestorConeccion.getInstance().beginTransaction();
            if ((new IntermediarioUsuario()).actualizar(user)) {
                GestorConeccion.getInstance().commitTransaction();
            } else {
                GestorConeccion.getInstance().rollbackTransaction();
            }
        } catch (Exception e) {
            throw new GenericException("No se pudo completar la operación de base de datos. Detalle: "+e);
        }
    }

    public void changePass(String... passwords) throws InvalidDataException, GenericException {

        if (passwords.length < 3) {
            throw new GenericException("Cantidad de parametros incorrecto");
        }
        Usuario user = _exp.getUser();
        String passOrg = Tools.Encriptador.getStringMessageDigest(user.getPassword(), "MD5");
        String passIn = Tools.Encriptador.getStringMessageDigest(passwords[0], "MD5");

        if (!passIn.equals(passOrg)) {
            throw new InvalidDataException("password", "password incorrecto");
        }

        String passNew = Tools.Encriptador.getStringMessageDigest(passwords[1], "MD5");
        String passConf = Tools.Encriptador.getStringMessageDigest(passwords[2], "MD5");

        if(!passNew.equals(passConf))
            throw new InvalidDataException("password nuevo, confirmación password", "no coinciden");

        modificarPass(user, passNew);
    }
}
