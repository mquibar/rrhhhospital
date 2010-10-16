/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Pais;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
public class IntermediarioPais extends Intermediario <Pais> {

    public IntermediarioPais() {
        _clase = "Pais";
        _log = LogAdmin.getInstance().getLog(this.getClass());


    }

    @Override
    public List<Pais> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pais> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Pais findPaisByNombre (String nombre) {
     try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findByNombre").setParameter(nombre, this);
            return (Pais)q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

}
