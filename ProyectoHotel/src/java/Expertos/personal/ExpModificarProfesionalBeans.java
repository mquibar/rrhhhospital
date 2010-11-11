/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Profesional;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import Entidades.Sexo;

/**
 *
 * @author Juan
 */

public class ExpModificarProfesionalBeans extends ExpModificarEmpleadoBeans implements ExpModificarProfesional {

    public boolean modificarProfesional (Profesional profesional, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo Sexo, String cuil, String matricula, String titulo) {

            profesional.setTitulo(titulo);
            profesional.setMatricula(matricula);

            return super.modificarEmpleado(profesional, nombre, apellido, dni, fechaNacimiento,
                    telefono, barrio, calle, numero, piso, departamanto, localidad, provincia, pais, Sexo, cuil);
    }
    

}
