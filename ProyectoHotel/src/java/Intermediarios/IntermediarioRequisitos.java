/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Entidades.Categoria;
import Entidades.Requisito;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Manuel
 */
public class IntermediarioRequisitos extends Intermediario<Requisito>{

    public IntermediarioRequisitos() {
        _clase="Requisito";
    }

    @Override
    public List<Requisito> findByDto(Object dto) {
        String sql = "SELECT r FROM " + _clase + " r WHERE r._categoria = :categ";
        Query q = GestorConeccion.getInstance().getManager().createQuery(sql);
        q.setParameter("categ", (Categoria)dto);
        try{
            return q.getResultList();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Requisito> findInOrden(String orden) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
