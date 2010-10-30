/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Domicilio;
import javax.ejb.Remote;

/**
 *
 * @author Juan
 */
@Remote
public interface ExpAltaDomicilio {

    public Entidades.Domicilio altaDomicilio(java.lang.String barrio, java.lang.String calle, java.lang.String numero, java.lang.String piso, java.lang.String departamanto, Entidades.Localidad localidad, Entidades.Provincia provincia);

}
