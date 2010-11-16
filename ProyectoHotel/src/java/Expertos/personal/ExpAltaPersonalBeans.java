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

    /* Inicia los datos que son comunes para todas las personas */
    public Map<String, List> iniciarPersonal(){
        Map<String,List> listas = new HashMap<String, List>();
        listas.put("TIPO", (new Intermediarios.IntermediarioTipoEmpleado()).findAll());
        listas.put("TARJETA", (new Intermediarios.IntermediarioTarjeta()).findAll());
        listas.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        listas.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        listas.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return listas;
    }

}
