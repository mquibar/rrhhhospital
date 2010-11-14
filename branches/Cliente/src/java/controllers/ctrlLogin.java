/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entidades.seguridad.Perfil;
import security.ExpNewUser;
import system.exception.SystemException;

/**
 *
 * @author leoroot
 */
public class ctrlLogin {

    ExpNewUser _exp;

    public ctrlLogin() {
        _exp = (ExpNewUser) (new GeneralController()).getExpert(ExpNewUser.class.getName());
    }

    public String login(String user, String pass) throws SystemException {
        try {
            _exp.newUser(user, pass, new Perfil[0]);
            return "Bienvenido al sistema";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getCurrentUserName() {
        return "Juan Ciullini";
    }
}
