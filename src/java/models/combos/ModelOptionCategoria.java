/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Categoria;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionCategoria extends AbstractModelOptionList<Categoria>{

    public ModelOptionCategoria(List<Categoria> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(Categoria objeto) {
        return objeto.getNombre();
    }

}
