/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Agrupamiento;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionAgrupamiento extends AbstractModelOptionList<Agrupamiento>{

    public ModelOptionAgrupamiento(List<Agrupamiento> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(Agrupamiento objeto) {
        return objeto.getNombre();
    }

}
