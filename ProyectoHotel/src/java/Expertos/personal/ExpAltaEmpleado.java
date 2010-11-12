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
public interface ExpAltaEmpleado {

    public void agregarEmpleado (Entidades.Empleado empleado);

    public boolean agregarLegajo(Entidades.Empleado empleado, int legajo);
    
    public java.util.Map<java.lang.String, java.util.List> iniciarEmpleado();

    public boolean iniciarAlta(Entidades.TipoEmpleado tipo, java.lang.String nombre, 
            java.lang.String apellido, java.lang.String dni, java.util.Date fechaNacimiento,
            long telefono, java.lang.String barrio, java.lang.String calle, java.lang.String numero,
            java.lang.String piso, java.lang.String departamanto, Entidades.Localidad localidad,
            Entidades.Provincia provincia, Entidades.Pais pais, Entidades.Sexo sexo, java.lang.String cuil,
            Entidades.Tarjeta tarjeta);

}
