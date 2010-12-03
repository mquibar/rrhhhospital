/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.seguridad.Usuario;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class TableUser extends AbstractTable<Usuario>{

    public TableUser(List<Usuario> _lista) {
        super(_lista, "Empleado","Legajo","Usuario","Contraseña");
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
