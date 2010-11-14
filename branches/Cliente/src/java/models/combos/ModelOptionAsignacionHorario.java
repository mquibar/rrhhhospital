/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.AsignacionHorario;
import Tools.ManejaFechas;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionAsignacionHorario extends AbstractModelOptionList<AsignacionHorario>{

    public ModelOptionAsignacionHorario(List<AsignacionHorario> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(AsignacionHorario objeto) {
        return objeto.getIdEmpleado().getNombre() + " " +
                objeto.getIdEmpleado().getApellido() + " - " +
                ManejaFechas.convertirDate(objeto.getFecha());
    }

}
