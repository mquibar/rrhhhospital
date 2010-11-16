/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Clase;
import java.util.List;

/**
 *
 * @author Juan
 */
public class ModelOptionClase extends AbstractModelOptionList<Clase> {

    public ModelOptionClase(List<Clase> lista) {
        super(lista);
    }


    @Override
    protected String devolverValorCombo(Clase objeto) {
        return objeto.getNombre();
    }

}
