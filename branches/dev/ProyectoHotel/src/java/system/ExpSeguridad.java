/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system;

import Entidades.seguridad.Operacion;
import Entidades.seguridad.Perfil;
import Entidades.seguridad.Usuario;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Manuel
 */
public class ExpSeguridad {

    private static ExpSeguridad _instance;
    private Usuario user;
    private Map operaciones;

    private ExpSeguridad(){

    }
    public static ExpSeguridad getInstance(){
        if(_instance== null)
            _instance=new ExpSeguridad();
        return _instance;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
        for (Perfil perfil : user.getPerfiles()) {
            for (Operacion operacion : perfil.getOperaciones()) {
               operaciones.put(operacion.hashCode(), operacion);
            }
        }
    }

    public boolean isOperationValid(Operacion operacion){
        return operaciones.containsKey(operacion.hashCode());
    }

}
