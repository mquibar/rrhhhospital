/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.limitadores;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author desarrollo
 */
public class LimitadorNumerico extends PlainDocument {


    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        for (char c : str.toCharArray()) {
            if(!Character.isDigit(c) ){
                Toolkit.getDefaultToolkit().beep();
                return;
            }
        }
        super.insertString(offs, str, a);
    }
}
