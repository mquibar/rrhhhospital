/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Domicilio;
import Entidades.Pais;
import Entidades.Sexo;
import java.util.Date;

/**
 *
 * @author MARIANO
 */
public interface ExpAltaProfesional {

    public void agregarProfesional (Entidades.Profesional profesional);
    public void iniciarAlta (String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, Domicilio idDomicilio, Pais idPais, Sexo idSexo, String matricula, String titulo);
    public boolean iniciarAlta (String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String Pais, String Sexo, String matricula, String titulo );



}
