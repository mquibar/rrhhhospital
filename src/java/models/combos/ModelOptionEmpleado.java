/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import Entidades.Empleado;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class ModelOptionEmpleado extends AbstractModelOptionList<Empleado>{

    public ModelOptionEmpleado(List<Empleado> lista) {
        super(lista);
    }

    @Override
    protected String devolverValorCombo(Empleado objeto) {
        return objeto.getNombre() + " " + objeto.getApellido();
    }

        public String toStringEmpleado(String empleado){
        try {
            if (options == null)
                toString();
            String nuevoString = options.replaceAll(">" + empleado, " selected=\"selected\" >"+ empleado);
            options = null;
            return nuevoString;
        } catch (Exception e) {
            return toString();
        }
    }


}
