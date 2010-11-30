/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Clase;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class TableClase extends AbstractTable<Clase> {

    public TableClase(List<Clase> _lista) {
        super(_lista, "Clase");
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            switch (columnIndex) {
                case 0:
                    return _lista.get(rowIndex).getNombre();
                default:
                    return "-";
            }
        } catch (Exception e) {
            return "-";
        }
    }

}
