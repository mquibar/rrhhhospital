/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.gestionUsuarios;

import Entidades.seguridad.Usuario;
import javax.swing.JOptionPane;
import managerrrhhhospital.ContextGenerator;
import security.GestorUserAdminRemote;
import system.exception.GenericException;
import system.exception.InvalidDataException;

/**
 *
 * @author Manuel
 */
public class ctrlChangeUser {

    public ctrlChangeUser(UiUserAdmin pantalla, Usuario user) {
        String pass = JOptionPane.showInputDialog(pantalla, "Ingrese la nueva contraseña", "pass");
        security.GestorUserAdminRemote gestor = (GestorUserAdminRemote) ContextGenerator.getInstance().createGestor(GestorUserAdminRemote.class.getName());
        try {
            gestor.modificarPass(user, pass);
        } catch (InvalidDataException ex) {
            JOptionPane.showMessageDialog(pantalla, ex,"Datos Invalidos",JOptionPane.ERROR_MESSAGE);
        } catch (GenericException ex) {
            JOptionPane.showMessageDialog(pantalla, ex,"Error de Sistema",JOptionPane.ERROR_MESSAGE);
        }   catch(NullPointerException np){
            JOptionPane.showMessageDialog(pantalla, "Debe seleccionar un usuario","Usuario Invalido",JOptionPane.INFORMATION_MESSAGE);
        }
    }


}
