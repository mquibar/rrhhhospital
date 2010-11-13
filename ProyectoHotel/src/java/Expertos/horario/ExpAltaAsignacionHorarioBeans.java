/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.AsignacionHorario;
import Entidades.Empleado;
import Entidades.TipoHorario;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioAsignacionHorario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaAsignacionHorarioBeans implements ExpAltaAsignacionHorario {

    private List<AsignacionHorario> _asignacionesHorario;
    private List<Boolean> _flagsSave;
    private boolean _esAlta = true;

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
            GestorConeccion.getInstance().beginTransaction();
            try
            {
                if( persistir(a) )
                {
                    GestorConeccion.getInstance().commitTransaction();
                    res = "La Asignacion de Horario se guardo correctamente";
                }
                else
                {
                    GestorConeccion.getInstance().rollbackTransaction();
                    res = "Error durante el guardado, Rolling Back";
                }
            }
            catch(Exception ex)
            {
                    res = "Error: se produjo el siguiente error durante el guardado : "
                            + ex.toString();
            }
        }

        return res;
    }

    Boolean persistir(AsignacionHorario a)
    {
        if(_esAlta)
        {
            return (new IntermediarioAsignacionHorario()).guardar(a);
        }
        else
        {
            return (new IntermediarioAsignacionHorario()).actualizar(a);
        }
    }


    public void agregarAsignacionHorario(AsignacionHorario asignacionHorario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            String idEntidad,
            Date fechaInicio,
            Date fechaFin,
            Empleado idEmpleado,
            TipoHorario idTipoHorario,
            String descripcion,
            boolean vigente
            ) {

        int idEnt = 0;
        if(idEntidad != null && idEntidad != "")
        {
            try
            {
                idEnt = Integer.parseInt(idEntidad);
                _esAlta = false;
                fechaInicio = fechaFin;
            }
            catch(Exception ex)
            {
                System.out.println(
                        "Error al tratar de modificar, agregando entidad nueva: " +
                        ex.toString());
            }
        }

        int difDias = fechaFin.compareTo(fechaInicio);

        for(int i=0; i < difDias; i++)
        {
            AsignacionHorario ah = new AsignacionHorario();
            
            if(!_esAlta)
            {
                ah.setId(idEnt);
            }

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
