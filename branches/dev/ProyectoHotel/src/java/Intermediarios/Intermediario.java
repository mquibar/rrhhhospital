/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import java.util.List;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;


/**
 *
 * @author desarrollo
 */
public abstract class Intermediario<E>{

    protected Log _log= LogAdmin.getInstance().getLog(this.getClass());
    protected String _clase;

    public List<E> findAll() {
        try{
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findAll");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    public boolean guardar(E obj){
        try{
            GestorConeccion.getInstance().getManager().persist(obj);
            return true;
        }catch(Exception ex){
            System.out.println("************* <Error al guardar>");
            ex.printStackTrace();
            _log.error(ex.getMessage());
            System.out.println("<\\Error> *************");
            return false;
        }
    }

    public boolean actualizar(E obj){
        try{
            GestorConeccion.getInstance().getManager().merge(obj);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return false;
        }
    }

    public List<E> findInOrden(String orden){

        Criteria criterio = ((Session)GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(_clase).addOrder(Order.asc(orden));
        return criterio.list();
    }
    public abstract List<E> findByDto(Object dto);
}
