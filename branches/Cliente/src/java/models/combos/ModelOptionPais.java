/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Pais;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionPais extends AbstractModelOptionList<Pais>{

    public ModelOptionPais(List<Pais> lista) {
        super(lista);
    }


    @Override
    protected String devolverValorCombo(Pais objeto) {
        return objeto.getPais();
    }

}
