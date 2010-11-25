/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Categoria;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class TableCategoria extends AbstractTable<Categoria>{

    public TableCategoria(List<Categoria> _lista) {
        super(_lista, "Nro.", "Categoría", "Cupo");
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            switch (columnIndex) {
                case 0:
                    return _lista.get(rowIndex).getNumero();
                case 1:
                    return _lista.get(rowIndex).getNombre();
                case 2:
                    return _lista.get(rowIndex).getCupo();
                default:
                    return "-";
            }
        } catch (Exception e) {
            return "-";
        }
    }


}
