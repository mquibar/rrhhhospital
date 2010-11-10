/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.TipoHorario;
import Expertos.horario.ExpAltaTipoHorario;
import Intermediarios.IntermediarioTipoHorario;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
public class ExpAltaTipoHorarioBeans implements ExpAltaTipoHorario {

    private TipoHorario _tipoHorario;
    private boolean _flagSave=false;

    public ExpAltaTipoHorarioBeans() {
        _tipoHorario = new TipoHorario();
    }
    
    public String guardar() {

        String res = "Error: se produjo un error durante el guardado";

        if(!_flagSave)
        {
            try
            {
                (new IntermediarioTipoHorario()).guardar(_tipoHorario);
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
