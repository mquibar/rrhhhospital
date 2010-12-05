/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.combos;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Manuel
 */
public abstract class AbstractCombo<E> extends DefaultComboBoxModel{

    List<E> _lista;

    public AbstractCombo(List<E> lista) {
        this._lista = lista;
        super.addElement("Selecione un Elemento");
    }
    

    public E getSelected(){
        int index = super.getIndexOf(super.getSelectedItem());
        try{
            return _lista.get(index-1);
        }catch(Exception e){
            return null;
        }
    }


}
