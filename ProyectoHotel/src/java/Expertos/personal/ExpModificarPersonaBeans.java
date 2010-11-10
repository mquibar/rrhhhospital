/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Empleado;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Persona;
import Entidades.Provincia;
import Expertos.personal.ExpModificarPersona;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */
@Stateless
public class ExpModificarPersonaBeans implements ExpModificarPersona {

    @EJB
    ExpAltaPersonalBeans expertoPersonal;

    public List<Empleado> listarEmpleados(){
        return ((new Intermediarios.IntermediarioEmpleado()).findAll());
    }
    
    public boolean modificarDomicilioPersona (Persona persona, String barrio, String calle, String numero,
            String piso, String departamanto, Localidad localidad, Provincia provincia, Pais pais){

        persona.getIdDomicilio().setCalle(calle);
        persona.getIdDomicilio().setBarrio(barrio);
        persona.getIdDomicilio().setNumero(Integer.getInteger(numero));
        persona.getIdDomicilio().setPiso(piso);
        persona.getIdDomicilio().setDepartamento(departamanto);
        persona.getIdDomicilio().setIdLocalidad(null);

        return (new Intermediarios.IntermediarioPersona().actualizar(persona));

    }


}
