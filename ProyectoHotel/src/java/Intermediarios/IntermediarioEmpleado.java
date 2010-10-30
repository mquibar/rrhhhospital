/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoEmpleado;
import Entidades.Empleado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author MARIANO
 */
public class IntermediarioEmpleado extends Intermediario<Empleado> {

    public IntermediarioEmpleado() {
        _clase="Empleado";
        _log = LogAdmin.getInstance().getLog(this.getClass());

    }

    @Override
    public List<Empleado> findByDto(Object dto) {
       DtoEmpleado dtoEmp = (DtoEmpleado) dto;
       Map<String, Object> restricciones = new HashMap<String, Object>();

        if (dtoEmp.getNombre() != null) {
            restricciones.put("nombre", dtoEmp.getNombre());
        }
        if (dtoEmp.getDni() != null) {
            restricciones.put("cuil", dtoEmp.getDni());
        }
        try {
            return crearQuery(restricciones).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Empleado> findInOrden(String orden) {
        Criteria criterio = ((Session)GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(_clase).addOrder(Order.asc(orden));
        return criterio.list();
    }

    public Empleado findByDni (String dni) {
            try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(super._clase + ".findByDni").setParameter(dni, this);
            return (Empleado)q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

     public Empleado findByCuil (String cuil) {
            try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findByCuil").setParameter(cuil, this);
            return (Empleado)q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }


}
