/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Localidad;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
public class IntermediarioLocalidad extends Intermediario <Localidad> {

    public IntermediarioLocalidad() {
        _clase = "Localidad";
        _log = LogAdmin.getInstance().getLog(this.getClass());

    }


    @Override
    public List<Localidad> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Localidad> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     public Localidad findLocalidadByNombre (String nombre) {
     try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findByNombre");
            return (Localidad)q.getResultList().get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }
}
