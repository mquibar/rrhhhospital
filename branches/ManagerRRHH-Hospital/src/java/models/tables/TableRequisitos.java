/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Requisito;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class TableRequisitos extends AbstractTable<Requisito> {

    public TableRequisitos(List<Requisito> _lista) {
        super(_lista, "Nro", "Descripción");
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            switch (columnIndex) {
                case 0:
                    return _lista.get(rowIndex).getNumero();
                case 1:
                    return _lista.get(rowIndex).getDescripcion();
                default:
                    return "-";
            }
        } catch (Exception e) {
            return "-";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex!=0)
            return true;
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(!isCellEditable(rowIndex, columnIndex))
            return;

        try{
            _lista.get(rowIndex).setDescripcion((String) aValue);
        }catch(Exception e){

        }
    }


}
