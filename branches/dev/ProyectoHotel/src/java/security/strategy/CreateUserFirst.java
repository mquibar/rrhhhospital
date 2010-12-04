/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security.strategy;

import Entidades.Empleado;

/**
 *
 * @author desarrollo
 */
class CreateUserFirst implements StrategyCreateUser{

    public String crearNombreUsuario(Empleado empleado) {
        return empleado.getNombre().substring(0, 1)+empleado.getApellido();
    }

}
