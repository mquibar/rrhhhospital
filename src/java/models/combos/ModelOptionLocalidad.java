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

    public String toStringLocalidad(String localidad){
        try {
            if (options == null)
                toString();
            String nuevoString = options.replaceAll(">" + localidad, " selected=\"selected\" >"+localidad);
            options = null;
            return nuevoString;
        } catch (Exception e) {
            return toString();
        }
    }

}
