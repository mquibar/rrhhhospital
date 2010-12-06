/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import security.GestorUserAdminRemote;

/**
 *
 * @author Manuel
 */
public class ctrlCambiarContraseña extends GeneralController {

    GestorUserAdminRemote _exp;

    public ctrlCambiarContraseña() {
        _exp = (GestorUserAdminRemote)getExpert(GestorUserAdminRemote.class.getName());
    }

    /**
     *
     * @param pass lista con todas las contraseñas actual, nueva y confirmacion de nueva
     * @throws Exception
     */
    public void cambiarPass(String... pass)throws Exception{
        /*for (int i = 0; i < pass.length; i++) {
        pass[i] = tools.EncriptadorCliente.getStringMessageDigest(pass[i], "MD5");

        }*/
        pass[0] = tools.EncriptadorCliente.getStringMessageDigest(pass[0], "MD5");
        _exp.changePass(pass);
    }

}
