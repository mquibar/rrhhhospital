/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Provincia;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionProvincia extends AbstractModelOptionList<Provincia>{

    public ModelOptionProvincia(List<Provincia> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(Provincia objeto) {
        return objeto.getProvincia();
    }

    public String toStringProvincia(String provincia){
        try {
            if (options == null)
                toString();
            String nuevoString = options.replaceAll(">" + provincia, " selected=\"selected\" >"+provincia);
            options = null;
            return nuevoString;
        } catch (Exception e) {
            return toString();
        }
    }

}
