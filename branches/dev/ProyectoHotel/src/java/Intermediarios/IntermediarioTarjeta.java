/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Tarjeta;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author MARIANO
 */
public class IntermediarioTarjeta extends Intermediario <Tarjeta> {

    public IntermediarioTarjeta() {
        _clase = "Tarjeta";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

   public Tarjeta findByNumero (long numero) {
         try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findByNumero").setParameter("numero", numero);
            return (Tarjeta)q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    public Tarjeta findById (int id) {
         try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findById").setParameter("id", id);
            return (Tarjeta)q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarjeta> findInOrden(String orden) {
        try{
            String query = "SELECT t FROM " + _clase + " t WHERE t NOT IN (SELECT e.idTarjeta FROM Empleado e WHERE e.eliminado is Null OR e.eliminado = false)";
            Query q = GestorConeccion.getInstance().getManager().createQuery(query);
            return q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tarjeta> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
