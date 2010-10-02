/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Tramo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Manuel
 */

public class IntermediarioTramo extends Intermediario<Tramo> {

    public IntermediarioTramo() {
        _log = LogAdmin.getInstance().getLog(this.getClass());
        _clase = "Tramo";
    }


    @Override
    public List<Tramo> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Tramo> findInOrden(String orden) {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Tramo.class).addOrder(Order.asc(orden));
        return criterio.list();
    }
    
}
