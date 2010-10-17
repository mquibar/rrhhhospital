/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.TipoEmpleado;
import Expertos.ExpAltaTipoEmpleado;
import Intermediarios.IntermediarioTipoEmpleado;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaTipoEmpleadoBeans implements ExpAltaTipoEmpleado {

    private TipoEmpleado _tipoEmpleado;
    private boolean _flagSave=false;

    public ExpAltaTipoEmpleadoBeans() {
        _tipoEmpleado = new TipoEmpleado();
    }
    
    public boolean guardarTipoEmpleado() {
        if(!_flagSave)
            return false;
        return (new IntermediarioTipoEmpleado()).guardar(_tipoEmpleado);
    }

    public void agregarTipoEmpleado(TipoEmpleado tipoEmpleado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            String nombre,
            String codigo
            ) {

        _tipoEmpleado.setNombre(nombre);
        _tipoEmpleado.setCodigo(codigo);

        _flagSave = validar();
    }

    private boolean validar()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
