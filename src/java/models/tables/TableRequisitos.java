/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Requisito;
import java.util.Collections;
import java.util.Comparator;
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

    public void sort(){
        Collections.sort(_lista, new Comparator<Requisito>() {

            public int compare(Requisito o1, Requisito o2) {
                if(o1.getNumero()<o2.getNumero())
                    return -1;
                else
                    if(o1.getNumero()==o2.getNumero())
                        return 0;
                    else
                        return 1;
            }
        });
        for (int i = 0; i < _lista.size(); i++) {
            _lista.get(i).setNumero(i+1);

        }
        fireTableDataChanged();
    }

}
