/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediarios;

import Configuraciones.LogAdmin;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.apache.commons.logging.Log;

/**
 *
 * @author desarrollo
 */
public abstract class Intermediario<E> {

    protected Log _log = LogAdmin.getInstance().getLog(this.getClass());
    protected String _clase;

    public List<E> findAll() {
        try {
            Query q = GestorConeccion.getInstance().getManager().createQuery("SELECT o FROM "+_clase + " o");
            return q.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    public boolean guardar(E obj) {
        try {
            GestorConeccion.getInstance().getManager().persist(obj);
            return true;
        } catch (Exception ex) {
            System.out.println("************* <Error al guardar>");
            ex.printStackTrace();
            _log.error(ex.getMessage());
            System.out.println("<\\Error> *************");
            return false;
        }
    }

    public boolean actualizar(E obj) {
        try {
            GestorConeccion.getInstance().getManager().merge(obj);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return false;
        }
    }

    public abstract List<E> findInOrden(String orden);

    public abstract List<E> findByDto(Object dto);

    protected Query crearQuery(Map<String, Object> restricciones) {
        String sql = "SELECT o FROM " + _clase + " o ";
        
        if (restricciones.isEmpty()) {
            return GestorConeccion.getInstance().getManager().createQuery(sql);
        }
        Query q = null;
        sql += "WHERE ";
        Iterator<String> i = restricciones.keySet().iterator();
        while (i.hasNext()) {
            String key = i.next();
            sql += "o." + key + "= :" + key + " AND ";
        }
        sql = sql.substring(0, sql.length()-5);
        q = GestorConeccion.getInstance().getManager().createQuery(sql);

        i = restricciones.keySet().iterator();
        while (i.hasNext()) {
            String key = i.next();
            q.setParameter(key, restricciones.get(key));
        }
        return q;
    }
}
