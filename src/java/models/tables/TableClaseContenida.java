/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.ClaseContenida;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class TableClaseContenida extends AbstractTable<ClaseContenida> {

    public TableClaseContenida(List<ClaseContenida> _lista) {
        super(_lista, "Nro","Clase","Ant Min");
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            switch (columnIndex) {
                case 0:
                    return _lista.get(rowIndex).getNumeroIndiceOrden();
                case 1:
                    return _lista.get(rowIndex).getClase().getNombre();
                case 2:
                    return _lista.get(rowIndex).getAntiguedadMinima();
                default:
                    return "-";
            }
        } catch (Exception e) {
            return "-";
        }
    }



}
