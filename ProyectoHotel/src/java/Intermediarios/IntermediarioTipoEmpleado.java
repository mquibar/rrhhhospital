/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.TipoEmpleado;
import Entidades.TipoLicencia;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Familia
 */

public class IntermediarioTipoEmpleado extends Intermediario<TipoEmpleado> {

    public IntermediarioTipoEmpleado() {
        _clase="TipoEmpleado";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    @Override
    public List<TipoEmpleado> findInOrden(String orden)
    {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(TipoEmpleado.class).addOrder(Order.asc(orden));
        return criterio.list();
    }

    @Override
    public List<TipoEmpleado> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
