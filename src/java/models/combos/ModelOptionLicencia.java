/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Licencia;
import Tools.ManejaFechas;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ModelOptionLicencia extends AbstractModelOptionList<Licencia>{

    public ModelOptionLicencia(List<Licencia> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(Licencia objeto) {
        return objeto.getIdEmpleado().getNombre() + " " +
                objeto.getIdEmpleado().getApellido() + " - " +
                ManejaFechas.convertirDate(objeto.getFechaInicio())+ " a " +
                ManejaFechas.convertirDate(objeto.getFechaInicio());
    }

}
