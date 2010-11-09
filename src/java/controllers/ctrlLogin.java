/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import javax.ejb.EJB;
import security.ExpLogIn;
import system.exception.SystemException;

/**
 *
 * @author leoroot
 */
public class ctrlLogin
{
    @EJB
    ExpLogIn _exp;

    public String login(String user, String pass) throws SystemException
    {
        pass = tools.Encriptador.getStringMessageDigest(pass, "MD5");
        _exp.logIn(user, pass);
        return "Bienvenido al sistema";
    }

    public String getCurrentUserName()
    {
        return "Juan Ciullini";
    }

}
