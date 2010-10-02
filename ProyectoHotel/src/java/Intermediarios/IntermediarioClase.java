/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Entidades.Clase;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Manuel
 */
public class IntermediarioClase extends Intermediario<Clase>{

    @Override
    public List<Clase> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Clase> findInOrden(String orden) {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Clase.class).addOrder(Order.asc(orden));
        return criterio.list();
    }

}
