/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.TipoLicencia;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionTipoLicencia extends AbstractModelOptionList<TipoLicencia>{

    public ModelOptionTipoLicencia(List<TipoLicencia> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(TipoLicencia objeto) {
        return objeto.getNombre();
    }

}
