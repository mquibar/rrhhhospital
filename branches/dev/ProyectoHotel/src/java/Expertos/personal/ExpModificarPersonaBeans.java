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
import Entidades.Sexo;
import Expertos.personal.ExpModificarPersona;


/**
 *
 * @author MARIANO
 */

public class ExpModificarPersonaBeans implements ExpModificarPersona {

  
    private Persona modificarDomicilioPersona (Persona persona, String barrio, String calle, String numero,
            String piso, String departamanto, Localidad localidad, Provincia provincia, Pais pais){

        persona.getIdDomicilio().setCalle(calle);
        persona.getIdDomicilio().setBarrio(barrio);
        persona.getIdDomicilio().setNumero(Integer.getInteger(numero));
        persona.getIdDomicilio().setPiso(piso);
        persona.getIdDomicilio().setDepartamento(departamanto);
        persona.getIdDomicilio().setIdLocalidad(localidad);
        persona.getIdDomicilio().setIdProvincia(provincia);
        persona.setIdPais(pais);

        return persona;
        
    }

    public boolean modificarDatosPersonales (Persona persona, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo Sexo) {

            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setDni(dni);
            persona.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));
            persona.setTelefono(Long.getLong(telefono));
            persona.setIdSexo(Sexo);
            persona = modificarDomicilioPersona(persona, barrio, calle, numero, piso, departamanto, localidad, provincia, pais);

            return new Intermediarios.IntermediarioPersona().actualizar(persona);
         

    }

}

