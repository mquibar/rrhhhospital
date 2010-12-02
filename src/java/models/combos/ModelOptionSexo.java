/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Sexo;
import java.util.List;

/**
 *
 * @author Juan
 */
public class ModelOptionSexo extends AbstractModelOptionList<Sexo> {

    public ModelOptionSexo(List<Sexo> lista) {
        super(lista);
    }


    @Override
    protected String devolverValorCombo(Sexo objeto) {
        return objeto.getSexo();
    }

    public String toStringSexo(String sexo){
        try {
            if (options == null)
                toString();
            String nuevoString = options.replaceAll(">" + sexo, " selected=\"selected\" >"+sexo);
            options = null;
            return nuevoString;
        } catch (Exception e) {
            return toString();
        }
    }
}
