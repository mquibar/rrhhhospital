/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Profesional;
import Entidades.Provincia;
import Entidades.Sexo;
import Expertos.ExpAltaProfesional;
import java.util.Date;

/**
 *
 * @author MARIANO
 */

public class ExpAltaProfesionalBeans extends ExpAltaEmpleadoBeans implements ExpAltaProfesional {

    public ExpAltaProfesionalBeans() {
        _persona = new Profesional();
    }

    public void agregarProfesional(Profesional profesional) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso,
            String departamanto, Localidad localidad, Provincia provincia, Pais pais, Sexo sexo,
            String cuil, String matricula, String titulo) {

        ((Profesional) _persona).setMatricula(matricula);
        ((Profesional) _persona).setTitulo(titulo);

        return super.iniciarAlta(nombre, apellido, dni, fechaNacimiento, telefono,
                barrio, calle, numero, piso, departamanto, localidad, provincia, pais, sexo, cuil);
    }
}
