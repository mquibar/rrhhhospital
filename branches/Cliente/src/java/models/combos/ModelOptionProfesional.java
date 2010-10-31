/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Profesional;
import java.util.List;

/**
 *
 * @author leoroot
 */
public class ModelOptionProfesional extends AbstractModelOptionList<Profesional>{

    public ModelOptionProfesional(List<Profesional> lista) {
        super(lista);
    }


    @Override
    protected String devolverValorCombo(Profesional objeto) {
        return objeto.getNombre() + " " + objeto.getApellido();
    }

}
