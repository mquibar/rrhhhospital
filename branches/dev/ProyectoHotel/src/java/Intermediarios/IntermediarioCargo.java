/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Cargo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;



/**
 *
 * @author Familia
 */
public class IntermediarioCargo extends Intermediario <Cargo> {

    public IntermediarioCargo(){
        _clase="Cargo";
        _log=LogAdmin.getInstance().getLog(this.getClass());
    }
    @Override
    public List<Cargo> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Cargo> findInOrden(String orden) {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Cargo.class).addOrder(Order.asc(orden));
        return criterio.list();
    }
}
