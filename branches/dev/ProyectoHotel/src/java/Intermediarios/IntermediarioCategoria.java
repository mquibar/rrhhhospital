/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import Configuraciones.LogAdmin;
import Entidades.Categoria;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Categoria> finAllInOrder(String order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
