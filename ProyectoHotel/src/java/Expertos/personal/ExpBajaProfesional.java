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
public interface ExpBajaProfesional {

    public java.util.Map<java.lang.String, java.util.List> listarProfesional();

    public boolean darBajaProfesional(Entidades.Profesional profesional);

}
