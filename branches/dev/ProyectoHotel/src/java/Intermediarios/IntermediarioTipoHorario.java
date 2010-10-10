/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.TipoHorario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Familia
 */

public class IntermediarioTipoHorario extends Intermediario<TipoHorario> {

    public IntermediarioTipoHorario() {
        _clase="TipoHorario";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    @Override
    public List<TipoHorario> findInOrden(String orden)
    {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(TipoHorario.class).addOrder(Order.asc(orden));
        return criterio.list();
    }

    @Override
    public List<TipoHorario> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
