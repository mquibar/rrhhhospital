/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.gestionUsuarios;

import Entidades.seguridad.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import managerrrhhhospital.ContextGenerator;
import models.combos.ComboPerfil;
import security.GestorUserAdminRemote;
import system.exception.GenericException;
import system.exception.InvalidDataException;

/**
 *
 * @author Manuel
 */
public class ctrlChangeUser {

    private ComboPerfil _perfiles;
    private security.GestorUserAdminRemote gestor;
    private Usuario user;
    private uiChangeUser _pantalla;

    public ctrlChangeUser(JDesktopPane pantalla, Usuario user) {

        gestor = (GestorUserAdminRemote) ContextGenerator.getInstance().createGestor(GestorUserAdminRemote.class.getName());
        this.user = user;
        _perfiles = new ComboPerfil(gestor.listarPerfiles());
        _pantalla.getCbxPerfil().setModel(_perfiles);

        _pantalla.getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressCancel();
            }
        });
        _pantalla.getBtnOk().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressOk();
            }
        });
        pantalla.add(_pantalla);
        _pantalla.setVisible(true);
    }

    void pressOk(){
        String pass="";
        for (char c : _pantalla.getTxtPass().getPassword()) {
            pass +=c;
        }
        try {
            gestor.modificarPass(user, pass, _perfiles.getSelected());
        } catch (InvalidDataException ex) {
            JOptionPane.showMessageDialog(_pantalla, ex,"Datos Invalidos",JOptionPane.ERROR_MESSAGE);
        } catch (GenericException ex) {
            JOptionPane.showMessageDialog(_pantalla, ex,"Error de Sistema",JOptionPane.ERROR_MESSAGE);
        }   catch(NullPointerException np){
            JOptionPane.showMessageDialog(_pantalla, "Debe seleccionar un usuario","Usuario Invalido",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    void pressCancel(){
        _pantalla.dispose();
    }



}
