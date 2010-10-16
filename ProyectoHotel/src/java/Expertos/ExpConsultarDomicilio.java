/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import javax.ejb.Remote;

/**
 *
 * @author Juan
 */
@Remote
public interface ExpConsultarDomicilio {

    public Provincia consultarProvincia (String provincia);

    public Localidad consultarLocalidad (String localidad);

    public Pais consultarPais (String pais);

    public Entidades.Domicilio consultarDomicilio(java.lang.String calle, java.lang.String numero, java.lang.String localidad, java.lang.String provincia, java.lang.String pais);
}
