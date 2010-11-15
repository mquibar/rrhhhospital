/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import security.ExpLogIn;
import system.exception.SystemException;

/**
 *
 * @author leoroot
 */
public class ctrlLogin {

    ExpLogIn _exp;

    public ctrlLogin() {
        _exp = (ExpLogIn) (new GeneralController()).getExpert(ExpLogIn.class.getName());
    }

    public void login(String user, String pass) throws SystemException {
            pass = tools.EncriptadorCliente.getStringMessageDigest(pass, "MD5");
            _exp.logIn(user, pass);
    }

    public String getCurrentUserName() {
        return "Juan Ciullini";
    }
}
