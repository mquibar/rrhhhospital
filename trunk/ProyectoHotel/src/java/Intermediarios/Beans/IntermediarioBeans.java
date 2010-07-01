/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios.Beans;

import Intermediarios.Intermediario;
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
public class IntermediarioBeans implements Intermediario{


    @PersistenceContext(unitName="ProyectoHotelPU")
    protected EntityManager _manager;

    protected static int _contador=0;

    public void beginTransaction() {
        if(_manager.isOpen()|| _contador>0){
            _contador++;
            return;
        }
        try{
            _manager.getTransaction().begin();
            _contador++;
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void commitTransaction() {
        if(_contador>0){
            _contador--;
        }
        if(_manager.isOpen())
            _manager.getTransaction().commit();
    }

    public void rollbackTransaction() {
        if(_contador>0){
            _contador--;
        }
        if(_manager.isOpen())
            _manager.getTransaction().rollback();
    }

}
