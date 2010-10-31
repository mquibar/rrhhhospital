/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.TipoHorario;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionTipoHorario extends AbstractModelOptionList<TipoHorario>{

    public ModelOptionTipoHorario(List<TipoHorario> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(TipoHorario objeto) {
        return objeto.getNombre();
    }

}
