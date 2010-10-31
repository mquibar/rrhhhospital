/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.TipoEmpleado;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionTipoEmpleado extends AbstractModelOptionList<TipoEmpleado>{

    public ModelOptionTipoEmpleado(List<TipoEmpleado> lista) {
        super(lista);
    }


    @Override
    protected String devolverValorCombo(TipoEmpleado objeto) {
        return objeto.getNombre();
    }

}
