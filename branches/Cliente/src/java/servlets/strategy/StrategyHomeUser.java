/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.strategy;

import Entidades.seguridad.Perfil;
import Entidades.seguridad.Usuario;

/**
 *
 * @author Manuel
 */
public class StrategyHomeUser {

    private static enum perfiles{USUARIO, ADMINISTRADOR, GERENCIA}
    public static String getHome(Usuario user){
        Perfil p =null;
        for (Perfil perfil : user.getPerfiles()) {
            p = perfil;
        }
        switch(perfiles.valueOf(p.getNombre().toUpperCase())){
            case USUARIO:
                return "homeUser.jsp?user="+user.getEmpleado().getNombre()+" "+user.getEmpleado().getApellido();
            case ADMINISTRADOR:
                return "home.jsp?user="+user.getEmpleado().getNombre()+" "+user.getEmpleado().getApellido();
            case GERENCIA:
                return "homeReport.jsp?user="+user.getEmpleado().getNombre()+" "+user.getEmpleado().getApellido();
        }
        return "#";
    }
}
