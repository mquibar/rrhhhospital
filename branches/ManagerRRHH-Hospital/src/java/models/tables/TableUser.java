/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.seguridad.Usuario;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class TableUser extends AbstractTable<Usuario>{

    public TableUser(List<Usuario> _lista) {
        super(_lista, "Empleado","Legajo","Usuario");
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            switch (columnIndex){
                case 0:
                    return _lista.get(rowIndex).getEmpleado().getApellido()+", "+_lista.get(rowIndex).getEmpleado().getNombre();
                case 1:
                    return _lista.get(rowIndex).getEmpleado().getLegajo();
                case 2:
                    return _lista.get(rowIndex).getNombre();
                default:
                    return "-";
            }
        }catch(Exception e){
            return "-";
        }
    }


}
