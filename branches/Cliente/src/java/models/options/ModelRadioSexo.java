/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.options;

import Entidades.Sexo;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelRadioSexo extends AbstractModelRadioButton<Sexo> {

    public ModelRadioSexo(List<Sexo> lista) {
        super(lista);
    }

    @Override
    protected String getValueAt(Sexo e) {
        return e.getSexo();
    }

}
