/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Manuel
 */
public abstract class AbstractTable<E> extends AbstractTableModel{

    protected String[] _columnNames;
    protected List<E> _lista;

    public AbstractTable(List<E> _lista, String ... columnNames) {
        this._columnNames = columnNames;
        this._lista = _lista;
    }
    
    public int getRowCount() {
        if(_lista == null)
            return 0;
        return _lista.size();
    }

    public int getColumnCount() {
        return _columnNames.length;
    }

    public void addRow(E e){
        _lista.add(e);
    }

    public void delRow(E e){
        _lista.remove(e);
    }
}
