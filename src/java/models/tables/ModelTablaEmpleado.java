/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Empleado;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class ModelTablaEmpleado extends AbstractModelTable <Empleado>{

    public ModelTablaEmpleado(List<Empleado> lista) {
        super(lista, "Nombre", "Apellido", "CUIT", "Legajo");
    }


    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        String value=null;
        try{

            switch(colIndex){
                case 0: value = _lista.get(rowIndex).getNombre();
                case 1: value = _lista.get(rowIndex).getApellido();
                case 2: value = _lista.get(rowIndex).getCuil();
                case 3: value = String.valueOf(_lista.get(rowIndex).getLegajo());
                default: value = "-";
            }
        }catch(Exception ex){
            value = "-";
        }
        if(value == null) value = "-";
        return value;
    }

}
