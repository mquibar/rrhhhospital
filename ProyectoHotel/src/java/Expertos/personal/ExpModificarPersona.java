/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Persona;


/**
 *
 * @author MARIANO
 */

public interface ExpModificarPersona {

    public Persona modificarDomicilioPersona(Entidades.Persona persona, java.lang.String barrio, java.lang.String calle, java.lang.String numero, java.lang.String piso, java.lang.String departamanto, Entidades.Localidad localidad, Entidades.Provincia provincia, Entidades.Pais pais);

    public boolean modificarDatosPersonales(Entidades.Persona persona, java.lang.String nombre,
            java.lang.String apellido, java.lang.String dni, java.lang.String fechaNacimiento,
            java.lang.String telefono, java.lang.String barrio, java.lang.String calle, java.lang.String numero,
            java.lang.String piso, java.lang.String departamanto, Entidades.Localidad localidad, Entidades.Provincia provincia,
            Entidades.Pais pais, Entidades.Sexo Sexo);
}

