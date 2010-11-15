/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.RegistroPeriodo;
import Tools.ManejaFechas;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionRegistroPeriodo extends AbstractModelOptionList<RegistroPeriodo>{

    public ModelOptionRegistroPeriodo(List<RegistroPeriodo> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(RegistroPeriodo objeto) {
        return objeto.getIdEmpleado().getNombre() + " " +
                objeto.getIdEmpleado().getApellido() + " - " +
                ManejaFechas.convertirDate(objeto.getFechaEntrada());
    }

}
