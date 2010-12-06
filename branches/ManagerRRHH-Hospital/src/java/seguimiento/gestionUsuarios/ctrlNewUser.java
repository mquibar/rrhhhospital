/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.gestionUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import managerrrhhhospital.ContextGenerator;
import models.combos.ComboPerfil;
import models.tables.TableEmpleado;
import security.ExpNewUser;
import system.exception.SystemException;

/**
 *
 * @author Manuel
 */
public class ctrlNewUser {

    private uiNewUser _pantalla;
    private ExpNewUser _gestor;
    private TableEmpleado _empleados;
    private ComboPerfil _perfiles;
    private ctrlUserAdmin _control;

    public ctrlNewUser(ctrlUserAdmin control, JDesktopPane panelPrincipal) {
        _pantalla = new uiNewUser();
        _gestor = (ExpNewUser) ContextGenerator.getInstance().createGestor(ExpNewUser.class.getName());
        _empleados= new TableEmpleado(_gestor.listarEmpleado());
        _pantalla.getTblEmpleados().setModel(_empleados);
        _perfiles = new ComboPerfil(_gestor.listarPerfil());
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
        _pantalla.setVisible(true);
        panelPrincipal.add(_pantalla);
        _control = control;
    }

    void pressCancel(){
        _pantalla.dispose();
        _control.refresh(false);
    }
    
    void pressOk(){
        if(_pantalla.getTblEmpleados().getSelectedRow()<0 || _perfiles.getSelected()==null ||_pantalla.getTxtPassword().getText().isEmpty())
            return;
        try {
            _gestor.newUser(_empleados.getSelectedIndex(_pantalla.getTblEmpleados().getSelectedRow()), _pantalla.getTxtPassword().getText(), _perfiles.getSelected());
            JOptionPane.showMessageDialog(_pantalla, "Usuario guardado con exito");
            _control.refresh(true);
        } catch (SystemException ex) {
            JOptionPane.showMessageDialog(_pantalla, ex.getMessage(), "Error al guardar usuario", JOptionPane.ERROR_MESSAGE);
        }
    }
}
