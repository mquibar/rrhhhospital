package Expertos.horario;

import Entidades.TipoHorario;
import Expertos.horario.consultar.ExpConsultarTipoHorarioBeans;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author leoroot
 */
@Stateless
public class ExpModificacionTipoHorarioBeans
        extends ExpertoModificacion<TipoHorario>
        implements ExpModificacionTipoHorario
{
    public ExpModificacionTipoHorarioBeans()
    {
        super("tipohorario");
    }

    @Override
    protected TipoHorario cargarEntidad(TipoHorario a, Object... data)
    {
        a.setNombre((String) data[0]);
        a.setDescripcion((String) data[1]);
        a.setHoraIngreso((Date) data[2]);
        a.setHoraSalida((Date) data[3]);
        a.setEliminado((Boolean) data[4]);

        return a;
    }

    @Override
    protected TipoHorario getById(int idEntidad)
    {
        return new ExpConsultarTipoHorarioBeans().consultarTipoHorarioPorId(idEntidad);
    }

    @Override
    protected int getId(TipoHorario o)
    {
        return o.getId();
    }

}
