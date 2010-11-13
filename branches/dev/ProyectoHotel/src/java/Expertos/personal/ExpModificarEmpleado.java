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
public interface ExpModificarEmpleado {

    public boolean modificarEmpleado(Entidades.Empleado empleado, java.lang.String nombre, 
            java.lang.String apellido, java.lang.String dni, java.lang.String fechaNacimiento,
            java.lang.String telefono, java.lang.String barrio, java.lang.String calle, java.lang.String numero,
            java.lang.String piso, java.lang.String departamanto, Entidades.Localidad localidad, Entidades.Provincia provincia,
            Entidades.Pais pais, Entidades.Sexo Sexo, java.lang.String cuil);

    public java.util.Map<java.lang.String, java.util.List> listarEmpleados();


}
