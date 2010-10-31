/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.options;

import java.util.List;

/**
 *
 * @author Manuel
 */
public abstract class AbstractModelRadioButton<E> {

    protected List<E> _lista;
    String radio=null;

    public AbstractModelRadioButton(List<E> lista) {
        this._lista = lista;
    }

    @Override
    public String toString() {
        if(radio!=null) return radio;
        for (E e : _lista) {
            radio="<input type=\"radio\" name=\""+this.getClass().getSimpleName()+"\">"+ getValueAt(e) +"</input> \n";
        }

        return radio;
    }

    public E getSelectedItem(int Index){
        return _lista.get(Index);
    }
    protected abstract String getValueAt(E e);
}
