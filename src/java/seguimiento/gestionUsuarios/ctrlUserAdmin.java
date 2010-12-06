/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.gestionUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import managerrrhhhospital.ContextGenerator;
import models.tables.TableUser;
import security.GestorUserAdminRemote;


/**
 *
 * @author Manuel
 */
public class ctrlUserAdmin {

    private UiUserAdmin _pantalla;
    private TableUser _userTable=null;
    private GestorUserAdminRemote _gestoUsuarios;
    private JPopupMenu _menuDerecho;
    private JDesktopPane _panelPrincipal;

    public ctrlUserAdmin(JDesktopPane panelPrincipal) {
        _panelPrincipal=panelPrincipal;
        _pantalla= new UiUserAdmin();
        _gestoUsuarios = (GestorUserAdminRemote) ContextGenerator.getInstance().createGestor(GestorUserAdminRemote.class.getName());
        _userTable = new TableUser(_gestoUsuarios.listarUsuarios());
        _pantalla.getTblUser().setModel(_userTable);
        
        _menuDerecho = new JPopupMenu("Gestión de Usuario");
        
        ActionListener actNew = new ActionNewUser(this);
        JMenuItem mnuItem = new JMenuItem("Crear Nuevo");
        mnuItem.addActionListener(actNew);
        _menuDerecho.add(mnuItem);
        _pantalla.getBtnNewUser().addActionListener(actNew);

        actNew = new ActionChangeUser(this);
        mnuItem = new JMenuItem("Cambiar Contraseña");
        mnuItem.addActionListener(actNew);
        _menuDerecho.add(mnuItem);
        _pantalla.getBtnChangeUser().addActionListener(actNew);

        _pantalla.getTblUser().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                checkActionPopUp(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                checkActionPopUp(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                checkActionPopUp(e);
            }

            private void checkActionPopUp(MouseEvent e){
                if(e.isPopupTrigger()){
                    _menuDerecho.show(_pantalla, e.getXOnScreen(), e.getYOnScreen());
                }
            }
        });
        _pantalla.setVisible(true);
        _panelPrincipal.add(_pantalla);
    }

    void refresh(boolean ref){
        if(ref){
            _userTable = new TableUser(_gestoUsuarios.listarUsuarios());
            _pantalla.getTblUser().setModel(_userTable);
        }
        _pantalla.setVisible(true);
    }

    void addUser(){
        new ctrlNewUser(this,_panelPrincipal);
        _pantalla.setVisible(false);
    }

    void changeUser(){
        if(_pantalla.getTblUser().getSelectedRow()<0)
            return;
        new ctrlChangeUser(_panelPrincipal, _userTable.getSelectedIndex(_pantalla.getTblUser().getSelectedRow()));
    }
}



class ActionNewUser implements ActionListener{

    private ctrlUserAdmin control;

    public ActionNewUser(ctrlUserAdmin control) {
        this.control = control;
    }

    public void actionPerformed(ActionEvent e) {
        control.addUser();
    }
}
class ActionChangeUser implements ActionListener{

    private ctrlUserAdmin control;

    public ActionChangeUser(ctrlUserAdmin control) {
        this.control = control;
    }
    
    public void actionPerformed(ActionEvent e) {
        control.changeUser();
    }
}
