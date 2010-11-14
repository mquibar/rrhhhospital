/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Empleado;
import Entidades.RegistroPeriodo;
import Expertos.horario.ExpAltaRegistroPeriodo;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioRegistroPeriodo;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaRegistroPeriodoBeans implements ExpAltaRegistroPeriodo {

    private RegistroPeriodo _registroPeriodo;
    private boolean _flagSave=false;
    private boolean _esAlta = true;

    public ExpAltaRegistroPeriodoBeans() {
        _registroPeriodo = new RegistroPeriodo();
    }
    
    public String guardar() {
        String res = "Error: se produjo un error durante la validacion";

        if(_flagSave)
        {
            GestorConeccion.getInstance().beginTransaction();
            try
            {
                if( persistir() )
                {
                    GestorConeccion.getInstance().commitTransaction();
                    res = "El Registro de Periodo se guardo correctamente";
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

    Boolean persistir()
    {
        if(_esAlta)
        {
            return (new IntermediarioRegistroPeriodo()).guardar(_registroPeriodo);
        }
        else
        {
            return (new IntermediarioRegistroPeriodo()).actualizar(_registroPeriodo);
        }
    }


    public void agregarRegistroPeriodo(RegistroPeriodo registroPeriodo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            String idEntidad,
            Empleado empleado,
            Date fechaEntrada,
            Date horaEntrada,
            Date fechaSalida,
            Date horaSalida,
            Boolean vigente
            ) {

        if(idEntidad != null && idEntidad != "")
        {
            try
            {
                _registroPeriodo.setId(Integer.parseInt(idEntidad));
                _esAlta = false;
            }
            catch(Exception ex)
            {
                System.out.println(
                        "Error al tratar de modificar, agregando entidad nueva: " +
                        ex.toString());
            }
        }

        _registroPeriodo.setFechaEntrada(fechaEntrada);
        _registroPeriodo.setHoraEntrada(horaEntrada);
        _registroPeriodo.setFechaSalida(fechaEntrada);
        _registroPeriodo.setHoraSalida(horaSalida);
        _registroPeriodo.setIdEmpleado(empleado.getIdEmpleado());

        _flagSave = validar();
    }

    private boolean validar()
    {
        return true;
    }

    RegistroPeriodo _th = null;
    public RegistroPeriodo getEntidad(String idEntidad)
    {
        if(_th == null)
        {
            try
            {
                int idE = Integer.parseInt(idEntidad);
                _th = new ExpConsultarRegistroPeriodoBeans().consultarAsignacionHorarioPorId(idE);
            }
            catch(Exception ex)
            {
                _th = new RegistroPeriodo();
            }
        }

        return _th;
    }

}
