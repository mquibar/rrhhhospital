/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Domicilio;
import Entidades.Empleado;
import Entidades.Pais;
import Entidades.Sexo;
import Expertos.ExpAltaEmpleado;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */
@Stateless
public class ExpAltaEmpleadoBeans implements ExpAltaEmpleado {

    private Empleado _empleado;

    public ExpAltaEmpleadoBeans() {
        _empleado = new Empleado();
    }

    public void agregarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, Domicilio idDomicilio, Pais idPais, Sexo idSexo, String cuil) {

    }

    public void iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String Sexo, String cuil) {
        //falta guardar el sexo
        _empleado.setNombre(nombre);
        _empleado.setApellido(apellido);
        _empleado.setDni(dni);
        _empleado.setFechaNacimiento(fechaNacimiento);
        _empleado.setTelefono(telefono);
        agregarDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia, pais);
        _empleado.setCuil(cuil);
    }

    private void agregarDomicilio (String barrio, String calle, String numero,
            String piso, String departamanto, String localidad, String provincia, String pais) {

        ExpAltaDomicilioBeans expertoD = new ExpAltaDomicilioBeans();
        ExpConsultarDomicilioBeans expertoC = new ExpConsultarDomicilioBeans();
        _empleado.setIdDomicilio(expertoD.altaDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia));
        _empleado.setIdPais(expertoC.consultarPais(pais));

    }

}
