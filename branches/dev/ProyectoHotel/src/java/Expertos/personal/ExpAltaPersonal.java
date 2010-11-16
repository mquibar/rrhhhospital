/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import javax.ejb.Remote;

/**
 *
 * @author MARIANO
 */

@Remote
public interface ExpAltaPersonal {

    public java.util.Map<java.lang.String, java.util.List> iniciarPersonal();

}