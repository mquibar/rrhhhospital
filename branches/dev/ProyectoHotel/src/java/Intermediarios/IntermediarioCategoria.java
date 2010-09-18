/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import DTO.DtoCategoria;
import Entidades.Categoria;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Familia
 */

public class IntermediarioCategoria extends Intermediario<Categoria> {

    public IntermediarioCategoria() {
        _clase="Categoria";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }


    @Override
    public List<Categoria> findByDto(Object dto) {
        DtoCategoria dtoCat = (DtoCategoria) dto;
        try {
            Criteria criteria = ((Session) GestorConeccion.getInstance().getManager().getDelegate()).createCriteria(Categoria.class);
            criteria.add(Restrictions.eq("nombre", dtoCat.getNombre()));
            return criteria.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            _log.error(ex.getMessage());
            return null;
        }
    }

}
