/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.combos;

import java.util.List;

/**
 *
 * @author Manuel
 */
public abstract class AbstractModelOptionList<E> {

    private List<E> _lista;
    protected String options = null;

    public AbstractModelOptionList(List<E> lista) {
        this._lista = lista;
    }

    @Override
    public String toString() {
        if (options != null) {
            return options;
        }
        options = "<option value=0>Selecciones un elemento</option>\n";
        for (int idx = 0; idx < _lista.size(); idx++) {
            options += "<option value=" + (idx + 1) + ">" + devolverValorCombo(_lista.get(idx)) + "</option>\n";

        }
        return options;
    }

    public String toString(String Index) {
        try {
            String nuevoString = options.replaceAll("value=" + Index, "value=" + Index + " selected=\"selected\"");
            options = null;
            return nuevoString;
        } catch (Exception e) {
            return toString();
        }
    }

    public void addOption(E e) {
        _lista.add(e);
        options = null;
    }

    public E getSelectedItem(int Index) {
        if (Index == 0) {
            return null;
        }
        return _lista.get(Index - 1);
    }

    public E getSelectedItem(String strIndex) {

        int Index = 0;

        try{Index = Integer.parseInt(strIndex);}
        catch(Exception ex){Index = 0;}

        if (Index == 0) {
            return null;
        }
        return _lista.get(Index - 1);
    }

    protected abstract String devolverValorCombo(E objeto);
}
