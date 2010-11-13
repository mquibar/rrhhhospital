/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Profesional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */

@Stateless
public class ExpBajaProfesionalBeans implements ExpBajaProfesional {

    public Map<String, List> listarProfesional(){
        Map<String,List> lista = new HashMap<String, List>();
        lista.put("PROFESIONAL", (new Intermediarios.IntermediarioProfesional()).findAll());
        return lista;
    }

    public boolean darBajaProfesional (Profesional profesional) {

       profesional.setEliminado(Boolean.TRUE);

       return (new Intermediarios.IntermediarioProfesional()).actualizar(profesional);
   }

}
