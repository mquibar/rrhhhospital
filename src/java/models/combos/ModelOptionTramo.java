/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Tramo;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionTramo extends AbstractModelOptionList<Tramo>{

    public ModelOptionTramo(List<Tramo> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(Tramo objeto) {
        return objeto.getNombre();
    }

}
