/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.TipoLicencia;
import Expertos.ExpAltaTipoLicencia;
import Intermediarios.IntermediarioTipoLicencia;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaTipoLicenciaBeans implements ExpAltaTipoLicencia {

    private TipoLicencia _tipoLicencia;
    private boolean _flagSave=false;

    public ExpAltaTipoLicenciaBeans() {
        _tipoLicencia = new TipoLicencia();
    }
    
    public boolean guardarTipoLicencia() {
        if(!_flagSave)
            return false;
        return (new IntermediarioTipoLicencia()).guardar(_tipoLicencia);
    }

    public void agregarTipoLicencia(TipoLicencia tipoLicencia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            String nombre,
            String descripcion
            ) {

        _tipoLicencia.setNombre(nombre);
        _tipoLicencia.setDescripcion(descripcion);
    }

}
