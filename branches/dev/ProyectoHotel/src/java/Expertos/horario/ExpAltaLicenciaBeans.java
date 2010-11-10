/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Empleado;
import Entidades.Licencia;
import Entidades.TipoLicencia;
import Expertos.horario.ExpAltaTipoLicencia;
import Intermediarios.IntermediarioLicencia;
import Intermediarios.IntermediarioTipoLicencia;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaLicenciaBeans implements ExpAltaLicencia {

    private Licencia _licencia;
    private boolean _flagSave=false;

    public ExpAltaLicenciaBeans() {
        _licencia = new Licencia();
    }
    
    public boolean guardarTipoLicencia() {
        if(!_flagSave)
            return false;
        return (new IntermediarioLicencia()).guardar(_licencia);
    }

    public void agregarLicencia(Licencia licencia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            Empleado idEmpleado,
            int idTipoLicencia,
            Date FechaInicio,
            Date FechaFin,
            String motivo
            ) {

        _licencia.setIdEmpleado(idEmpleado);
        _licencia.setIdTipoLicencia(idTipoLicencia);
        _licencia.setFechaInicio(FechaInicio);
        _licencia.setFechaFin(FechaFin);
        _licencia.setMotivo(motivo);

        _flagSave = validar();
    }

    private boolean validar()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
