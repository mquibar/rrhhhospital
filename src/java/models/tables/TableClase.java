/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Clase;
import java.util.Collections;
import java.util.Comparator;
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

    public void sort() {
        Collections.sort(_lista, new Comparator<Clase>() {

            public int compare(Clase o1, Clase o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        });
        fireTableDataChanged();
    }

}
