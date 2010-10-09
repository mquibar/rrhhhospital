/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;

/**
 *
 * @author Juan
 */
public interface ExpConsultarDomicilio {

    public Provincia consultarProvincia (String provincia);

    public Localidad consultarLocalidad (String localidad);

    public Pais consultarPais (String pais);
}
