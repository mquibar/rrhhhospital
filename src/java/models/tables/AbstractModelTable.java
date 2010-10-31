/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import java.util.List;

/**
 *
 * @author Manuel
 */
public abstract class AbstractModelTable<E> {

    protected String[] columnsName;
    protected List<E> _lista;
    private String tabla=null;
    
    public AbstractModelTable(List<E> lista, String ... columnsName) {
        this.columnsName = columnsName;
        this._lista=lista;
    }

    @Override
    public String toString() {
        if(tabla !=null) return tabla;
        tabla = "<table border = 1>\n <thead>\n <tr>\n";
        for (String string : columnsName) {
            tabla+=" <th><a>"+ string+"</a></th>\n";
        }
        tabla +="</tr>\n </thead>\n </tbody>\n <tr>\n";
        for (int row = 0; row < _lista.size(); row++) {
            tabla += " <tr>\n";
            for (int col = 0; col < columnsName.length; col++) {
                tabla += "<td>" + getValueAt(row, col) + "</td>\n";
            }
            tabla +=" </tr>\n";

        }
        tabla +=" </tbody>\n </table>";

        return tabla;
    }


    public abstract Object getValueAt(int rowIndex, int colIndex);

    public E getRow(int rowIndex){
        return _lista.get(rowIndex);
    }
}
