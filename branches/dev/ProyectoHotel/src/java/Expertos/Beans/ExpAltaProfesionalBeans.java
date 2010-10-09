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

    private Profesional _profesional;

    public void agregarProfesional(Profesional profesional) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*Ver si implementar*/ 
    public void iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento, long telefono, Domicilio idDomicilio, Pais idPais, Sexo idSexo, String matricula, String titulo) {
       
    }

    public void iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento, long telefono, String barrio, String calle, String numero, String piso, String departamanto, String localidad, String provincia, String pais, String sexo, String matricula, String titulo) {
        //falta guardar el sexo
        _profesional.setNombre(nombre);
        _profesional.setApellido(apellido);
        _profesional.setDni(dni);
        _profesional.setFechaNacimiento(fechaNacimiento);
        _profesional.setTelefono(telefono);
        agregarDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia, pais);
        _profesional.setMatricula(matricula);
        _profesional.setTitulo(titulo);
        
    }

    public void agregarDomicilio (String barrio, String calle, String numero, String piso, String departamanto, String localidad, String provincia, String pais) {

        ExpAltaDomicilioBeans expertoD = new ExpAltaDomicilioBeans();
        ExpConsultarDomicilioBeans expertoC = new ExpConsultarDomicilioBeans();
        _profesional.setIdDomicilio(expertoD.altaDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia));
        _profesional.setIdPais(expertoC.consultarPais(pais));


    }

    

}
