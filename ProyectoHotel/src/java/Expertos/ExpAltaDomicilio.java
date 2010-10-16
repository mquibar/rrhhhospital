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

    public Domicilio altaDomicilio (String barrio, String calle, String numero, String piso, String departamanto, String localidad, String  Provincia);

}
