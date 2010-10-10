/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Profesional;
import java.util.List;
import DTO.DTOProfesional;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;


/**
 *
 * @author MARIANO
 */
public class IntermediarioProfesional extends Intermediario <Profesional> {

    public IntermediarioProfesional() {
        _clase = "Profesional";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    @Override
    public List findByDto(Object dto) {
       DTOProfesional dtoPro = (DTOProfesional) dto;
       Map<String, Object> restricciones = new HashMap<String, Object>();

        if (dtoPro.getNombre() != null) {
            restricciones.put("nombre", dtoPro.getNombre());
        }
        if (dtoPro.getDni() != null) {
            restricciones.put("dni", dtoPro.getDni());
        }
        try {
            return crearQuery(restricciones).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Profesional> findInOrden(String orden) {
        Criteria criterio = ((Session)GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(_clase).addOrder(Order.asc(orden));
        return criterio.list();
    }
 

}
