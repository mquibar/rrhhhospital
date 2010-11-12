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

    public boolean iniciarAlta(String nombre, String apellido, String dni, java.util.Date fechaNacimiento, 
            long telefono, String barrio, String calle, String numero, String piso, String departamanto, Entidades.Localidad localidad,
            Entidades.Provincia provincia, Entidades.Pais pais, Entidades.Sexo sexo);

    public java.util.Map<java.lang.String, java.util.List> iniciarPersonal();

}