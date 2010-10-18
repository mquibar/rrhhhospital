/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoCategoria;
import Entidades.Categoria;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Familia
 */
public class IntermediarioCategoria extends Intermediario<Categoria> {

    public IntermediarioCategoria() {
        _clase = "Categoria";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    @Override
    public List<Categoria> findByDto(Object dto) {
        DtoCategoria dtoCat = (DtoCategoria) dto;
        Map<String, Object> restricciones = new HashMap<String, Object>();
        
        if (dtoCat.getNombre() != null) {
            restricciones.put("nombre", dtoCat.getNombre());
        }
        if (dtoCat.getTramo() != null) {
            restricciones.put("idTramo", dtoCat.getTramo());
        }
        if(dtoCat.isEliminada())
            restricciones.put("_eliminado", dtoCat.isEliminada());
        try {
            return crearQuery(restricciones).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Categoria> findInOrden(String orden) {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Categoria.class).addOrder(Order.asc(orden));
        return criterio.list();
    }
}
