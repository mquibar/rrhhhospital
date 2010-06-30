/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios.Beans;

import Intermediarios.Fachada;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author desarrollo
 */
@Stateless
public class FachadaBeans implements Fachada{

    @PersistenceUnit(name="ProyectoHotelPU")
    protected static EntityManagerFactory _factory = Persistence.createEntityManagerFactory("ProyectoHotelPU", System.getProperties());

    @PersistenceContext
    protected EntityManager _manager;

    public void beginTransaction() {
        if(_manager.isOpen())
            return;
        try{
        _manager = _factory.createEntityManager();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void commitTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void rollbackTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
