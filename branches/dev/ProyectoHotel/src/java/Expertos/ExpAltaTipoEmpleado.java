/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.TipoEmpleado;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface  ExpAltaTipoEmpleado {

    public void agregarTipoEmpleado (TipoEmpleado tipoEmpleado);
    public void iniciarAlta (
            String nombre,
            String codigo
            );

    public boolean guardarTipoEmpleado();

}
