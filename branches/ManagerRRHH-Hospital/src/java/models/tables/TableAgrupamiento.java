/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Agrupamiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class TableAgrupamiento extends AbstractTable<Agrupamiento>{

    private List<Agrupamiento> _listaSinFiltro;
    private boolean _editable = false;

    public TableAgrupamiento(List<Agrupamiento> _lista) {
        super(_lista, "Agrupamiento");
        _listaSinFiltro = new ArrayList<Agrupamiento>(_lista);
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

    public void filter(String filtro){
        _lista= _listaSinFiltro;
        List<Agrupamiento> nuevalista = new ArrayList<Agrupamiento>();
        for (Agrupamiento agrupamiento : _lista) {
            if(agrupamiento.getNombre().contains(filtro))
                nuevalista.add(agrupamiento);
        }
        _lista = nuevalista;
        fireTableDataChanged();
    }

    public void clearFilter(){
        _lista=_listaSinFiltro;
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return _editable;
    }

    public void setEditable(boolean editable) {
        this._editable = editable;
    }


}
