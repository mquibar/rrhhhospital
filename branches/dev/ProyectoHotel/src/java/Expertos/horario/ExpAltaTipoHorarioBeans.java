/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.TipoHorario;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author leoroot
 */
@Stateless
public class ExpAltaTipoHorarioBeans 
        extends ExpertoAlta<TipoHorario>
        implements ExpAltaTipoHorario
{
    public ExpAltaTipoHorarioBeans()
    {
        super("tipohorario");
    }

    @Override
    protected TipoHorario getEntidad(String idEntidad)
    {
        return new TipoHorario();
    }

    @Override
    protected TipoHorario cargarEntidad(TipoHorario a, Object... data)
    {
        try
        {
            a.setNombre((String) data[0]);
            a.setDescripcion((String) data[1]);
            a.setHoraIngreso((Date) data[2]);
            a.setHoraSalida((Date) data[3]);
            a.setEliminado((Boolean) data[4]);
        }
        catch(Exception ex)
        {
            System.out.println("Error al cargar entidad: " + ex);
        }

        return a;
    }


}
