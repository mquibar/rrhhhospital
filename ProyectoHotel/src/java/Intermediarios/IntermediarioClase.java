/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import DTO.DtoClase;
import Entidades.Clase;
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
public class IntermediarioClase extends Intermediario<Clase>{

    public IntermediarioClase() {
        _clase = "Clase";
    }


    @Override
    public List<Clase> findByDto(Object dto) {
        DtoClase dtoClase = (DtoClase)dto;
        Map<String,Object> restricciones = new HashMap<String, Object>();
        if(dtoClase.getNombre()!=null)
            restricciones.put("nombre", dtoClase.getNombre());
        return crearQuery(restricciones).getResultList();
    }

    @Override
    public List<Clase> findInOrden(String orden) {
        Criteria criterio = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Clase.class).addOrder(Order.asc(orden));
        return criterio.list();
    }

}
