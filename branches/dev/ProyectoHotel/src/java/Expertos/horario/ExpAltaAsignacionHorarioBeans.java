/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Expertos.horario.consultar.ExpConsultarAsignacionHorarioBeans;
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
                    res = "La Asignacion de Horario se guardo correctamente. Confirmado.<br />";
                    System.out.println(res);
                    GestorConeccion.getInstance().commitTransaction();
                }
                else
                {
                    res = "Error durante el guardado, Rolling Back";
                    System.out.println(res);
                    GestorConeccion.getInstance().rollbackTransaction();
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
            boolean eliminado
            ) {

        int idEnt = 0;
        if(idEntidad != null && !idEntidad.isEmpty())
        {
            try
            {
                idEnt = Integer.parseInt(idEntidad);
                _esAlta = false;
                fechaFin = fechaInicio;
            }
            catch(Exception ex)
            {
                System.out.println(
                        "Error al tratar de modificar, agregando entidad nueva: " +
                        ex.toString());
            }
        }

        int difDias = diferencia(fechaInicio, fechaFin);

        System.out.println("Comenzando seteo de " + difDias + " asignaciones.");
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
            ah.setVigente(!eliminado);
            
            _asignacionesHorario.add(ah);
            _flagsSave.add(validar(ah));
        }
    }

    private boolean validar(AsignacionHorario a)
    {
        return true;
    }

    AsignacionHorario _th = null;
    AsignacionHorario getEntidad(String idEntidad)
    {
        if(_th == null)
        {
            try
            {
                int idE = Integer.parseInt(idEntidad);
                _th = new ExpConsultarAsignacionHorarioBeans().consultarAsignacionHorarioPorId(idE);
            }
            catch(Exception ex)
            {
                _th = new AsignacionHorario();
            }
        }

        return _th;
    }

    int diferencia(Date inicio, Date fin)
    {
        return (int)(Math.floor(fin.getTime() - inicio.getTime())/ (1000 * 60 * 60 * 24)) + 1;
    }
}
