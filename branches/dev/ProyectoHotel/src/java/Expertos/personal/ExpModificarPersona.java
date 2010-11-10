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
public interface ExpModificarPersona {

    public boolean modificarDomicilioPersona(Entidades.Persona persona, java.lang.String barrio, java.lang.String calle, java.lang.String numero, java.lang.String piso, java.lang.String departamanto, Entidades.Localidad localidad, Entidades.Provincia provincia, Entidades.Pais pais);

    public java.util.List<Entidades.Empleado> listarEmpleados();

}
