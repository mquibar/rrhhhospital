/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios.Beans;

import Configuraciones.LogAdmin;
import Entidades.Categoria;
import Intermediarios.IntermediarioCategoria;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Familia
 */
@Stateless
public class IntermediarioCategoriaBean extends IntermediarioBeans<Categoria> implements IntermediarioCategoria<Categoria> {

    public IntermediarioCategoriaBean (){
        _clase="Categoria";
        _log = LogAdmin.getInstance().getLog(this.getClass());
    }

    @Override
    public List<Categoria> findByDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Categoria> finAllInOrder(String order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
