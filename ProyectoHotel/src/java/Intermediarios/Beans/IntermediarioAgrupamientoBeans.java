/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios.Beans;

import Configuraciones.LogAdmin;
import Entidades.Agrupamiento;
import Intermediarios.IntermediarioAgrupamiento;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author desarrollo
 */
@Stateless
public class IntermediarioAgrupamientoBeans extends IntermediarioBeans implements IntermediarioAgrupamiento{

    public IntermediarioAgrupamientoBeans(){
        _log = LogAdmin.getInstance().getLog(this.getClass());
        _clase = "Agrupamiento";
    }

    @Override
    public boolean guardar(Object obj) {
        Agrupamiento agrupamiento = (Agrupamiento)obj;
        try{
            GestorConeccion.getInstance().beginTransaction();
            GestorConeccion.getInstance().getManager().persist(agrupamiento);
            GestorConeccion.getInstance().commitTransaction();
            return true;
        }catch(Exception ex){
            GestorConeccion.getInstance().rollbackTransaction();
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Object obj) {
        Agrupamiento agrupamiento = (Agrupamiento)obj;
        try{
            GestorConeccion.getInstance().beginTransaction();
            GestorConeccion.getInstance().getManager().merge(agrupamiento);
            GestorConeccion.getInstance().commitTransaction();
            return true;
        }catch(Exception ex){
            GestorConeccion.getInstance().rollbackTransaction();
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Object> finAllInOrder(String order) {
        try {
            Session s = (Session) GestorConeccion.getInstance().getManager().getDelegate();
            Criteria c = s.createCriteria(Agrupamiento.class).addOrder(Order.asc(order));
            return c.list();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            _log.error(hibernateException.getMessage());
            return new ArrayList<Object>();
        }
    }

    public Agrupamiento findByName(String nombre) {
        try{
            Query q = GestorConeccion.getInstance().getManager().createNativeQuery("SELECT a FROM Agrupamiento a WHERE a.nombre= :nombre");
            q.setParameter("nombre", nombre);
            return    (Agrupamiento) q.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }
    

}
