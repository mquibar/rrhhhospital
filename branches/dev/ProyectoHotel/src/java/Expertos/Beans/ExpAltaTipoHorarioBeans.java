/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.TipoHorario;
import Entidades.TipoLicencia;
import Expertos.ExpAltaTipoHorario;
import Expertos.ExpAltaTipoLicencia;
import Intermediarios.IntermediarioTipoHorario;
import Intermediarios.IntermediarioTipoLicencia;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaTipoHorarioBeans implements ExpAltaTipoHorario {

    private TipoHorario _tipoHorario;
    private boolean _flagSave=false;

    public ExpAltaTipoHorarioBeans() {
        _tipoHorario = new TipoHorario();
    }
    
    public boolean guardarTipoHorario() {
        if(!_flagSave)
            return false;
        return (new IntermediarioTipoHorario()).guardar(_tipoHorario);
    }

    public void agregarTipoHorario(TipoHorario tipoHorario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            String nombre,
            String descripcion,
            Date horarioEntrada,
            Date horarioSalida
            ) {

        _tipoHorario.setNombre(nombre);
        _tipoHorario.setDescripcion(descripcion);
        _tipoHorario.setHoraIngreso(horarioEntrada);
        _tipoHorario.setHoraSalida(horarioSalida);

        _flagSave = validar();
    }

    private boolean validar()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
