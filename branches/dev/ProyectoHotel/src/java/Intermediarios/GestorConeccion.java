/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.commons.logging.Log;

/**
 *
 * @author desarrollo
 */
public class GestorConeccion {

    //@PersistenceUnit
    private EntityManagerFactory _factory;
    private EntityManager _manager=null;
    private int _contador=0;
    private static GestorConeccion _instance=null;
    private Log _log;

    public static GestorConeccion getInstance(){
        if(_instance == null)
            _instance = new GestorConeccion();
        return _instance;
    }

    public GestorConeccion(){
        _factory = Persistence.createEntityManagerFactory("ProyectoHotelPU");
        _log = Configuraciones.LogAdmin.getInstance().getLog(this.toString());
    }

    public void beginTransaction() {
        if(_manager != null )
            if(_manager.isOpen() && _contador>0){
                _contador++;
                return;
        }
        try{
            if(!_manager.isOpen())
                _manager=_factory.createEntityManager();
            _manager.getTransaction().begin();
            _contador++;
        }catch(Exception ex){
            ex.printStackTrace();
            _log.error(ex.getMessage());
        }
    }

    public void commitTransaction() throws Exception {
        if(_contador>1){
            _contador--;
            return;
        }
        if(_manager.isOpen()){
            try{
                _manager.getTransaction().commit();
            }catch(Exception ex){
                ex.printStackTrace();
                _log.error(ex.getMessage());
                throw new Exception(ex);
            }finally{
                _contador = 0;
            }
        }
    }

    public void rollbackTransaction() {
        if(_contador>1){
            _contador--;
            return;
        }
        if(_manager.isOpen()){
            try{
                _manager.getTransaction().rollback();
            }catch(Exception ex){
                ex.printStackTrace();
                _log.error(ex.getMessage());
            }finally{
                _contador = 0;
            }
        }
    }

    public EntityManager getManager(){
        if(_manager == null)
            _manager = _factory.createEntityManager();
        return _manager;
    }

}
