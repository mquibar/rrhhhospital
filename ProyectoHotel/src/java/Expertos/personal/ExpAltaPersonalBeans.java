/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Persona;
import Entidades.Provincia;
import Entidades.Sexo;
import Expertos.personal.ExpAltaPersonal;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioPersona;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */

@Stateless
public class ExpAltaPersonalBeans implements ExpAltaPersonal {

    protected Persona _persona;

    public ExpAltaPersonalBeans() {
    }

    public ExpAltaPersonalBeans(Persona _personal) {
        this._persona = _personal;
    }

    public Map<String, List> iniciarPersonal(){
        Map<String,List> listas = new HashMap<String, List>();
        listas.put("TIPO", (new Intermediarios.IntermediarioTipoEmpleado()).findAll());
        listas.put("TARJETA", (new Intermediarios.IntermediarioTarjeta()).findAll());
        listas.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        listas.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        listas.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return listas;
    }

    //Inicia a una persona
    public boolean iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso,
            String departamanto, Localidad localidad, Provincia provincia, Pais pais, Sexo sexo) {
        boolean resultado;
        _persona.setNombre(nombre);
        _persona.setApellido(apellido);
        _persona.setDni(dni);
        _persona.setFechaNacimiento(fechaNacimiento);
        _persona.setTelefono(telefono);
        agregarDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia, pais);
        _persona.setIdSexo(sexo);

        GestorConeccion.getInstance().beginTransaction();
        try{
            if( (new IntermediarioPersona()).guardar(_persona) ){
                resultado = true;
                GestorConeccion.getInstance().commitTransaction();
            }
            else{
                resultado = false;
                GestorConeccion.getInstance().rollbackTransaction();
            }
        }catch(Exception ex){
            System.out.println("************ <Error en el Experto de Alta de Persona>");
            ex.printStackTrace();
            System.out.println("<\\Error> *****************");
            resultado = false;
        }
        return resultado;
    }

    //Agrega el domicilio a la persona
    private void agregarDomicilio (String barrio, String calle, String numero,
            String piso, String departamanto, Localidad localidad, Provincia provincia, Pais pais) {

        _persona.setIdDomicilio((new ExpAltaDomicilioBeans()).altaDomicilio(barrio, calle, numero, piso, departamanto, localidad, provincia));
        _persona.setIdPais(pais);

    }
}
