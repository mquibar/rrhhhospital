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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */
@Stateless
public class ExpModificarProfesionalBeans implements ExpModificarProfesional {


    public Map<String, List> listarProfesional(){
        Map<String,List> lista = new HashMap<String, List>();
        lista.put("PROFESIONAL", (new Intermediarios.IntermediarioProfesional()).findAll());
        lista.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        lista.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        lista.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return lista;
    }

    public boolean modificarProfesional (Profesional profesional, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo sexo, String cuil,
            String matricula, String titulo) {


            profesional.setNombre(nombre);
            profesional.setApellido(apellido);
            profesional.setDni(dni);
            profesional.setFechaNacimiento(Tools.ManejaFechas.convertirString(fechaNacimiento));
            profesional.setTelefono(Long.getLong(telefono));
            profesional.setIdSexo(sexo);
            profesional.setCuil(cuil);
            profesional = modificarDomicilioProfesional (profesional, barrio, calle,
                     numero, piso, departamanto, localidad, provincia, pais);
            profesional.setTitulo(titulo);
            profesional.setMatricula(matricula);

            return new Intermediarios.IntermediarioEmpleado().actualizar(profesional);
    }

    private Profesional modificarDomicilioProfesional (Profesional profesional, String barrio,
            String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais){

            profesional.getIdDomicilio().setCalle(calle);
            profesional.getIdDomicilio().setBarrio(barrio);
            profesional.getIdDomicilio().setNumero(Integer.getInteger(numero));
            profesional.getIdDomicilio().setPiso(piso);
            profesional.getIdDomicilio().setDepartamento(departamanto);
            profesional.getIdDomicilio().setIdLocalidad(localidad);
            profesional.getIdDomicilio().setIdProvincia(provincia);
            profesional.setIdPais(pais);

        return profesional;

    }

}
