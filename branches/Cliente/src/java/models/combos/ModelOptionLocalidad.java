/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Localidad;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionLocalidad extends AbstractModelOptionList<Localidad> {

    public ModelOptionLocalidad(List<Localidad> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(Localidad objeto) {
        return objeto.getLocalidad();
    }

}
