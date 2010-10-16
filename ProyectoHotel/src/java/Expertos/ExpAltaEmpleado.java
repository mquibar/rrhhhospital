/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Domicilio;
import Entidades.Pais;
import Entidades.Sexo;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Juan
 */
@Remote
public interface ExpAltaEmpleado {

    public void agregarEmpleado (Entidades.Empleado empleado);
    public void iniciarAlta (String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, Domicilio idDomicilio, Pais idPais, Sexo idSexo, String cuil);
    public void iniciarAlta (String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String Sexo, String cuil);

}
