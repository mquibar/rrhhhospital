/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Tarjeta;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class ModelOptionTarjeta extends AbstractModelOptionList<Tarjeta> {

    public ModelOptionTarjeta(List<Tarjeta> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(Tarjeta objeto) {
        return objeto.getId().toString();
    }

}
