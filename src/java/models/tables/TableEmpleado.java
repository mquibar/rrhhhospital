/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Empleado;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class TableEmpleado extends AbstractTable<Empleado>{

    public TableEmpleado(List<Empleado> _lista) {
        super(_lista, "Apellido", "Nombre", "Legajo");
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            switch(columnIndex){
                case 0: return _lista.get(rowIndex).getApellido();
                case 1: return _lista.get(rowIndex).getNombre();
                case 2: return _lista.get(rowIndex).getLegajo();
                default: return "-";
            }
        }catch(Exception e){
            return "-";
        }
    }

}
