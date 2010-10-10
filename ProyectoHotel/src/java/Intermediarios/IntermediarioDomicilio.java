/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DTODomicilio;
import Entidades.Domicilio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Juan
 */
public class IntermediarioDomicilio extends Intermediario <Domicilio>{

    public IntermediarioDomicilio() {
        _clase = "Domicilio";
        _log = LogAdmin.getInstance().getLog(this.getClass());

    }

    @Override
    public List<Domicilio> findInOrden(String orden) {
        Criteria criterio = ((Session)GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(_clase).addOrder(Order.asc(orden));
        return criterio.list();
    }

    @Override
    public List<Domicilio> findByDto(Object dto) {
       DTODomicilio dtoDom = (DTODomicilio) dto;
       Map<String, Object> restricciones = new HashMap<String, Object>();

        if (dtoDom.getCalle() != null) {
            restricciones.put("calle", dtoDom.getCalle());
        }
        if (dtoDom.getNumero() != null) {
            restricciones.put("numero", dtoDom.getNumero());
        }
        try {
            return crearQuery(restricciones).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
