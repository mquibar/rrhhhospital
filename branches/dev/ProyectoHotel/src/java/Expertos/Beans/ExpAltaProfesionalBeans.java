/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Domicilio;
import Entidades.Pais;
import Entidades.Profesional;
import Entidades.Sexo;
import Expertos.ExpAltaProfesional;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */
@Stateless
public class ExpAltaProfesionalBeans implements ExpAltaProfesional {

    public void agregarProfesional(Profesional profesional) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento, long telefono, Domicilio idDomicilio, Pais idPais, Sexo idSexo, String matricula, String titulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
