/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.TipoLicencia;

/**
 *
 * @author Manuel
 */
public interface  ExpAltaTipoLicencia {

    public void agregarTipoLicencia (TipoLicencia tipoLicencia);
    public void iniciarAlta (
            String nombre,
            String descripcion
            );

}
