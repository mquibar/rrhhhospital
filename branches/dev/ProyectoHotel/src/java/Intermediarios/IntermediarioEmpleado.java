/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Empleado;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class IntermediarioEmpleado extends Intermediario <Empleado> {

    public IntermediarioEmpleado() {
        _clase="Empleado";
        _log = LogAdmin.getInstance().getLog(this.getClass());

    }

    @Override
    public List findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Empleado> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
