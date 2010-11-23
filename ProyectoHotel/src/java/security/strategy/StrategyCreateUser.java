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
public interface StrategyCreateUser {

    public String crearNombreUsuario(Empleado empleado);
}
