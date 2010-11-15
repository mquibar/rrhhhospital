/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoTramo;
import Entidades.Tramo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        DtoTramo dtoTramo = (DtoTramo) dto;
        Map<String,Object> restricciones = new HashMap<String, Object>();
        if (dtoTramo.getAgrupamiento() != null) {
            restricciones.put("idAgrupamiento", dtoTramo.getAgrupamiento());
        }
        if (dtoTramo.getNombre() != null) {
            restricciones.put("nombre", dtoTramo.getNombre());
        }
        if (dtoTramo.getCategoria()!=null){
            restricciones.put("categoriaList", dtoTramo.getCategoria());
        }
        return crearQuery(restricciones).getResultList();
    }

    @Override
    public List<Tramo> findInOrden(String orden) {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Tramo.class).addOrder(Order.asc(orden));
        return criterio.list();
    }
}
