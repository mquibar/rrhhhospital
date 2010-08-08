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
public class IntermediarioAgrupamientoBeans extends IntermediarioBeans<Agrupamiento> implements IntermediarioAgrupamiento<Agrupamiento>{

    public IntermediarioAgrupamientoBeans(){
        _log = LogAdmin.getInstance().getLog(this.getClass());
        _clase = "Agrupamiento";
    }

    @Override
    public List<Agrupamiento> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Agrupamiento> finAllInOrder(String order) {
        try {
            Session s = (Session) GestorConeccion.getInstance().getManager().getDelegate();
            Criteria c = s.createCriteria(Agrupamiento.class).addOrder(Order.asc(order));
            return c.list();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            _log.error(hibernateException.getMessage());
            return new ArrayList<Agrupamiento>();
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
