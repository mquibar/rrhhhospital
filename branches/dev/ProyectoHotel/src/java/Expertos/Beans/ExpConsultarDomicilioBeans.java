/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import DTO.DTODomicilio;
import Entidades.Domicilio;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import Expertos.ExpConsultarDomicilio;
import Intermediarios.Intermediario;
import Intermediarios.IntermediarioDomicilio;
import Intermediarios.IntermediarioLocalidad;
import Intermediarios.IntermediarioPais;
import Intermediarios.IntermediarioProvincia;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */
@Stateless
public class ExpConsultarDomicilioBeans implements ExpConsultarDomicilio {

    /* Consulta una provincia en particular por nombre */
    public Provincia consultarProvincia(String nombre) {
        IntermediarioProvincia intermediario = new IntermediarioProvincia ();
        Provincia provincia;
        try {
            provincia = intermediario.findProvinciaByNombre(nombre);
        } catch (NullPointerException e) {
            provincia=null;
        }
        return provincia;
    }

    /* Consulta una Localidad en particular por nombre */
    public Localidad consultarLocalidad(String nombre) {
        IntermediarioLocalidad intermediario = new IntermediarioLocalidad ();
        Localidad localidad;
        try {
            localidad = intermediario.findLocalidadByNombre(nombre);
        } catch (NullPointerException e) {
            localidad = null;
        }
        return localidad;
    }

    /* Consulta un Pais en particular por nombre */
    public Pais consultarPais(String nombre) {
       IntermediarioPais intermediario = new IntermediarioPais ();
        Pais pais;
        try {
            pais = intermediario.findPaisByNombre(nombre);
        } catch (NullPointerException e) {
            pais=null;
        }
        return pais;
    }

    /* Consulta Domicilio especifico */
    /*relizar con DTO*/
    public Domicilio consultarDomicilio (String calle, String numero, String localidad, String provincia, String pais) {
        IntermediarioDomicilio intermediario = new IntermediarioDomicilio();
        Domicilio domicilio;
        DTODomicilio dto = new DTODomicilio();
        dto.setCalle(calle);
        dto.setNumero(numero);
        dto.setLocalidad(localidad);
        dto.setProvincia(provincia);
        dto.setPais(pais);
        try {
            domicilio = intermediario.findByDto(dto).get(0);
        } catch (NullPointerException e) {
            domicilio=null;
        }
        dto=null;
        intermediario=null;
        return domicilio;
    }

    /*Devuleve la lista de paises del sistema */
    public List<Pais> consultarTodosPaises () {
        IntermediarioPais intermediario = new IntermediarioPais ();
        List <Pais> pais;
        try {
            pais = intermediario.findAll();
        } catch (NullPointerException e) {
            pais=null;
        }
        return pais;
     }

    /*Devuleve la lista de localidades del sistema */
    public List<Localidad> consultarTodasLocalidades () {
        IntermediarioLocalidad intermediario = new IntermediarioLocalidad ();
        List <Localidad> localidad;
        try {
            localidad = intermediario.findAll();
        } catch (NullPointerException e) {
            localidad = null;
        }
        return localidad;
     }

    /*Devuleve la lista de provincias del sistema */
    public List<Provincia> consultarTodasProvincias () {
       IntermediarioProvincia intermediario = new IntermediarioProvincia ();
        List <Provincia> provincia;
        try {
            provincia = intermediario.findAll();
        } catch (NullPointerException e) {
            provincia=null;
        }
        return provincia;
     }
    

}
