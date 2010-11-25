/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Tramo;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class TableTramo extends AbstractTable<Tramo> {

    public TableTramo(List<Tramo> _lista) {
        super(_lista, "Tramo");
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
