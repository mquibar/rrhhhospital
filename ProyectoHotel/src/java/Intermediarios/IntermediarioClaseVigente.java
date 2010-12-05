/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Categoria;
import Entidades.ClaseVigente;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
public class IntermediarioClaseVigente extends Intermediario<ClaseVigente>{

    public IntermediarioClaseVigente() {
        _clase="ClaseVigente";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    @Override
    public List<ClaseVigente> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ClaseVigente> findByDto(Object dto) {
        Query q = GestorConeccion.getInstance().getManager().createQuery("SELECT c FROM ClaseVigente c WHERE c.idEmpleado=:emp");
        q.setParameter("emp", dto);
        return q.getResultList();
    }

    public List<ClaseVigente> findVigenteByCategoria(Categoria c){
        Query q = GestorConeccion.getInstance().getManager().createQuery("SELECT c FROM "+ _clase + " c WHERE c.vigente = :vig and c.idCategoria = :cat");
        q.setParameter("vig", true);
        q.setParameter("cat", c);
        return q.getResultList();
    }

}