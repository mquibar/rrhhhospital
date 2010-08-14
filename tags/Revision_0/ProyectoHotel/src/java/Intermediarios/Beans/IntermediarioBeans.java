/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios.Beans;

import Configuraciones.LogAdmin;
import Intermediarios.Intermediario;
import java.util.List;
import javax.persistence.Query;
import org.apache.commons.logging.Log;

/**
 *
 * @author desarrollo
 */
public abstract class IntermediarioBeans<E> implements Intermediario<E>{

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
            GestorConeccion.getInstance().beginTransaction();
            GestorConeccion.getInstance().getManager().persist(obj);
            GestorConeccion.getInstance().commitTransaction();
            return true;
        }catch(Exception ex){
            GestorConeccion.getInstance().rollbackTransaction();
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return false;
        }
    }

    public boolean actualizar(E obj){
        try{
            GestorConeccion.getInstance().beginTransaction();
            GestorConeccion.getInstance().getManager().merge(obj);
            GestorConeccion.getInstance().commitTransaction();
            return true;
        }catch(Exception ex){
            GestorConeccion.getInstance().rollbackTransaction();
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return false;
        }
    }

    public abstract List<E> findByDto(Object dto);

}
