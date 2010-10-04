/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoAgrupamiento;
import Entidades.Agrupamiento;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author desarrollo
 */
public class IntermediarioAgrupamiento extends Intermediario<Agrupamiento>{

    public IntermediarioAgrupamiento() {
        _log = LogAdmin.getInstance().getLog(this.getClass());
        _clase = "Agrupamiento";
    }


    @Override
    public List<Agrupamiento> findByDto(Object dto) {
        try {
            DtoAgrupamiento dtoAgrupamiento = (DtoAgrupamiento) dto;
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery("Agrupamiento.findByNombre");
            q.setParameter("nombre", dtoAgrupamiento.getNombre());
            return q.getResultList();
        } catch (Exception ex) {
            System.out.println("**************** "+ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Agrupamiento> findInOrden(String orden) {
        Criteria criterio = ((Session)GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Agrupamiento.class).addOrder(Order.asc(orden));
        try{return criterio.list();}catch(Exception ex){ex.printStackTrace();return null;}
    }
   
}
