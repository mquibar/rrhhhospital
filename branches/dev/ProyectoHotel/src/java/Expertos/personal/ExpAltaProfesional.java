/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;


/**
 *
 * @author MARIANO
 */

public interface ExpAltaProfesional extends ExpAltaEmpleado {

    public void agregarProfesional (Entidades.Profesional profesional);

    public boolean iniciarAlta(String nombre, String apellido, String dni, java.util.Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso,
            String departamanto, Entidades.Localidad localidad, Entidades.Provincia provincia, Entidades.Pais pais,
            Entidades.Sexo sexo, String cuil, String matricula, String titulo);

    public java.util.Map<java.lang.String, java.util.List> iniciarProfesional();

}
