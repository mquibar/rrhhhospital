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
public abstract class IntermediarioBeans implements Intermediario{

    protected Log _log= LogAdmin.getInstance().getLog(this.getClass());
    protected String _clase;

    public List<Object> findAll() {
        try{
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findAll");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    public abstract boolean guardar(Object obj);

    public abstract boolean actualizar(Object obj);

    public abstract List<Object> findByDto(Object dto);

}
