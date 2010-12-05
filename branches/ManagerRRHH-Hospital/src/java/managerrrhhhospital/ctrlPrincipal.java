/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package managerrrhhhospital;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.UnsupportedLookAndFeelException;
import seguimiento.gestionCategoria.ctrlAdminEscalafon;
import seguimiento.gestionUsuarios.ctrlUserAdmin;

/**
 *
 * @author Manuel
 */
public class ctrlPrincipal {

    private uiPrincipal _pantalla;

    public ctrlPrincipal() {
        _pantalla = new uiPrincipal();
        _pantalla.getMnuExit().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        _pantalla.getMnuCategorias().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new ctrlAdminEscalafon(_pantalla.getDskPanel());
            }
        });

        _pantalla.getMnuUsuarios().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new ctrlUserAdmin(_pantalla.getDskPanel());
            }
        });
        
        _pantalla.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            try {
                //                    javax.swing.UIManager.setLookAndFeel(new de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel());
                javax.swing.UIManager.setLookAndFeel(new de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (ParseException ex) {
            System.out.println(ex.getMessage() + "**********");
            ex.getStackTrace();
        }

        new ctrlPrincipal();
    }

}
