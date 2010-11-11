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

    public ExpAltaTipoHorarioBeans() {
        _tipoHorario = new TipoHorario();
    }
    
    public String guardar() {

        String res = "Error: se produjo un error durante la validacion";

        if(_flagSave)
        {
            GestorConeccion.getInstance().beginTransaction();
            try
            {
                if( (new IntermediarioTipoHorario()).guardar(_tipoHorario) )
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
        return true;
    }

}
