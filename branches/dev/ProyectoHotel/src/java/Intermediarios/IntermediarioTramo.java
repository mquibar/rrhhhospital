/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoTramo;
import Entidades.Tramo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
        DtoTramo dtoTramo = (DtoTramo) dto;
        Criteria c = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Tramo.class);
        if (dtoTramo.getAgrupamiento() != null) {
            c.createAlias("idAgrupamiento", "a");
            c.add(Restrictions.eq("a", dtoTramo.getAgrupamiento()));
        }
        if (dtoTramo.getNombre() != null) {
            c.add(Restrictions.eq("nombre", dtoTramo.getNombre()));
        }

        return c.list();
    }

    @Override
    public List<Tramo> findInOrden(String orden) {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Tramo.class).addOrder(Order.asc(orden));
        return criterio.list();
    }
}
