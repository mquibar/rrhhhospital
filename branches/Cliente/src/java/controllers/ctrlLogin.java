/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entidades.seguridad.Usuario;
import security.ExpLogIn;
import system.exception.SystemException;

/**
 *
 * @author leoroot
 */
public class ctrlLogin {

    ExpLogIn _exp;
    private static Usuario user = null;

    public ctrlLogin() {
        _exp = (ExpLogIn) (new GeneralController()).getExpert(ExpLogIn.class.getName());
    }

    public String login(String user, String pass) throws SystemException {
            pass = tools.EncriptadorCliente.getStringMessageDigest(pass, "MD5");
            Usuario u = _exp.logIn(user, pass);
            ctrlLogin.user=u;
            return u.getEmpleado().getNombre() + " " + u.getEmpleado().getApellido();
    }

    public String getCurrentUserName() {
        if( user == null)
            return "";
        return user.getEmpleado().getNombre() + " " + user.getEmpleado().getApellido();
    }

    public void logoff(){
        _exp.logOff();
        user=null;
    }
}
