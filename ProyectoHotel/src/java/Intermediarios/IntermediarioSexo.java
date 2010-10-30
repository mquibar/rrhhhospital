/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Sexo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author MARIANO
 */
public class IntermediarioSexo extends Intermediario <Sexo>{

    public IntermediarioSexo() {
        _clase = "Sexo";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    @Override
    public List<Sexo> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Sexo> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Sexo findBySexo (String sexo) {
         try {
            Query q = GestorConeccion.getInstance().getManager().createNamedQuery(_clase + ".findBySexo").setParameter(sexo, this);
            return (Sexo)q.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

}
