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

    protected String toStringPais(String pais){
        try {
            if (options == null)
                toString();
            String nuevoString = options.replaceAll(">" + pais, " selected=\"selected\" >"+pais);
            options = null;
            return nuevoString;
        } catch (Exception e) {
            return toString();
        }
    }

}
