/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.AsignacionHorario;
import Entidades.Empleado;
import Entidades.TipoHorario;
import Expertos.horario.ExpAltaAsignacionHorario;
import Intermediarios.IntermediarioAsignacionHorario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaAsignacionHorarioBeans implements ExpAltaAsignacionHorario {

    private List<AsignacionHorario> _asignacionesHorario;
    private List<Boolean> _flagsSave;

    public ExpAltaAsignacionHorarioBeans() {
        _asignacionesHorario = new ArrayList<AsignacionHorario>();
        _flagsSave = new ArrayList<Boolean>();
    }
    
    public String guardar()
    {
        String res = "";

        for(int i = 0; i<_asignacionesHorario.size(); i++)
        {
            res += guardar(_asignacionesHorario.get(i), _flagsSave.get(i)) + "\n";
        }

        return res;
    }
    
    String guardar(AsignacionHorario a, Boolean f) {
        String res = "Error: se produjo un error durante el guardado";

        if(f)
        {
            try
            {
                (new IntermediarioAsignacionHorario()).guardar(a);
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

        int difDias = fechaFin.compareTo(fechaInicio);

        for(int i=0; i < difDias; i++)
        {
            AsignacionHorario ah = new AsignacionHorario();
            
            Date asigDate = new Date(
                    fechaInicio.getYear(),
                    fechaInicio.getMonth(),
                    fechaInicio.getDate() + i);
            
            ah.setFecha(asigDate);
            ah.setIdEmpleado(idEmpleado);
            ah.setIdTipoHorario(idTipoHorario);
            ah.setDescripcion(descripcion);
            ah.setVigente(vigente);
            
            _asignacionesHorario.add(ah);
            _flagsSave.add(validar(ah));
        }
    }

    private boolean validar(AsignacionHorario a)
    {
        return true;
    }

}
