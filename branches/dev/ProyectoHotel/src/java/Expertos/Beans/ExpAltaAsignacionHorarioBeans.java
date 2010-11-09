/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.AsignacionHorario;
import Entidades.Empleado;
import Entidades.TipoHorario;
import Expertos.ExpAltaAsignacionHorario;
import Intermediarios.IntermediarioAsignacionHorario;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaAsignacionHorarioBeans implements ExpAltaAsignacionHorario {

    private AsignacionHorario _asignacionHorario;
    private boolean _flagSave=false;

    public ExpAltaAsignacionHorarioBeans() {
        _asignacionHorario = new AsignacionHorario();
    }
    
    public String guardar() {
        String res = "Error: se produjo un error durante el guardado";

        if(_flagSave)
        {
            try
            {
                (new IntermediarioAsignacionHorario()).guardar(_asignacionHorario);
                res = "La asignacion de Horario se guardo correctamente";
            }
            catch(Exception ex)
            {
                res = "Error: se produjo el siguiente error durante el guardado : "
                        + ex.getMessage();
            }
        }

        return res;
    }

    public void agregarAsignacionHorario(AsignacionHorario asignacionHorario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            Date fechaInicio,
            Date fechaFin,
            Empleado idEmpleado,
            TipoHorario idTipoHorario,
            String descripcion,
            boolean vigente
            ) {

        _asignacionHorario.setFecha(fechaFin);
        _asignacionHorario.setIdEmpleado(idEmpleado);
        _asignacionHorario.setIdTipoHorario(idTipoHorario);
        _asignacionHorario.setDescripcion(descripcion);
        _asignacionHorario.setVigente(vigente);
        
        _flagSave = validar();
    }

    private boolean validar()
    {
        return true;
    }

}
