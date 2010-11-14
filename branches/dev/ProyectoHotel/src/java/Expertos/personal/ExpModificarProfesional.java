/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import javax.ejb.Remote;

/**
 *
 * @author Juan
 */

@Remote
public interface ExpModificarProfesional {

    public java.util.Map<java.lang.String, java.util.List> listarProfesional();

    public boolean modificarProfesional(Entidades.Profesional profesional, 
            java.lang.String nombre, java.lang.String apellido, java.lang.String dni,
            java.lang.String fechaNacimiento, java.lang.String telefono, java.lang.String barrio,
            java.lang.String calle, java.lang.String numero, java.lang.String piso,
            java.lang.String departamanto, Entidades.Localidad localidad,
            Entidades.Provincia provincia, Entidades.Pais pais, Entidades.Sexo sexo,
            java.lang.String cuil, java.lang.String matricula, java.lang.String titulo);



}
