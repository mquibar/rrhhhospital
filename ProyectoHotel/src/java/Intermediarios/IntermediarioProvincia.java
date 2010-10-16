/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Provincia;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
public class IntermediarioProvincia extends Intermediario<Provincia> {

    public IntermediarioProvincia() {
        _clase = "Provincia";
        _log = LogAdmin.getInstance().getLog(this.getClass());

    }

    @Override
    public List<Provincia> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Provincia> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Provincia findProvinciaByNombre (String nombre) {
     try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findByNombre").setParameter(nombre, this);
            return (Provincia)q.getSingleResult();
     } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

}
