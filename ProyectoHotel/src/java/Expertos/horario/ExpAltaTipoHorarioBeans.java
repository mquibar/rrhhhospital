/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.TipoHorario;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioTipoHorario;
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
    private boolean _esAlta = true;


    public ExpAltaTipoHorarioBeans() {
        _tipoHorario = new TipoHorario();
    }
    
    public String guardar() {

        String res = "Error: se produjo un error durante la validacion";

        if(_flagSave)
        {
            try
            {
                GestorConeccion gc = GestorConeccion.getInstance();
                gc.beginTransaction();
                if( persistir() )
                {
                    res = "El Tipo de Horario se guardo correctamente. Confirmado.";
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
                    res = "Error: se produjo el siguiente error durante el guardado : <br />"
                            + ex.toString();
            }
        }

        return res;
    }

    Boolean persistir()
    {
        if(_esAlta)
        {
            System.out.println("Iniciando Alta...\n" + _tipoHorario);
            return (new IntermediarioTipoHorario()).guardar(_tipoHorario);
        }
        else
        {
            System.out.println("Iniciando Modificacion...\n" + _tipoHorario);
            return (new IntermediarioTipoHorario()).actualizar(_tipoHorario);
        }
    }

    public void agregarTipoHorario(TipoHorario tipoHorario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            String idEntidad,
            String nombre,
            String descripcion,
            Date horarioEntrada,
            Date horarioSalida,
            Boolean eliminado
            ) {
        if(idEntidad != null && !idEntidad.equals(""))
        {
            try
            {
                _tipoHorario.setId(Integer.parseInt(idEntidad));
                _esAlta = false;
                _tipoHorario = getEntidad(idEntidad);
                System.out.println("Modificando entidad con id '" + _tipoHorario.getId() + "'...");
            }
            catch(Exception ex)
            {
                System.out.println(
                        "Error al tratar de modificar, agregando entidad nueva: " +
                        ex.toString());
            }
        }

        _tipoHorario.setNombre(nombre);
        _tipoHorario.setDescripcion(descripcion);
        _tipoHorario.setHoraIngreso(horarioEntrada);
        _tipoHorario.setHoraSalida(horarioSalida);
        _tipoHorario.setEliminado(eliminado);

        _flagSave = validar();
    }

    private boolean validar()
    {
        return true;
    }

    TipoHorario _th = null;
    public TipoHorario getEntidad(String idEntidad)
    {
        if(_th == null)
        {
            try
            {
                int idE = Integer.parseInt(idEntidad);
                _th = new ExpConsultarTipoHorarioBeans().consultarTipoHorarioPorId(idE);
            }
            catch(Exception ex)
            {
                _th = new TipoHorario();
            }
        }

        return _th;
    }


}
