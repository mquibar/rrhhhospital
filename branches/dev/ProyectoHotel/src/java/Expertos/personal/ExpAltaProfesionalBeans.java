/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Profesional;
import Entidades.Provincia;
import Entidades.Sexo;
import Expertos.ExpAltaProfesional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MARIANO
 */

public class ExpAltaProfesionalBeans extends ExpAltaEmpleadoBeans implements ExpAltaProfesional {

    public ExpAltaProfesionalBeans() {
        _persona = new Profesional();
    }

    public Map<String, List> iniciarProfesional(){
        Map<String,List> listas = new HashMap<String, List>();
        listas.put("TIPO", (new Intermediarios.IntermediarioTipoEmpleado()).findAll());
        listas.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        listas.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        listas.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return listas;
    }

    public void agregarProfesional(Profesional profesional) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso,
            String departamanto, Localidad localidad, Provincia provincia, Pais pais, Sexo sexo,
            String cuil, String matricula, String titulo) {

        ((Profesional) _persona).setMatricula(matricula);
        ((Profesional) _persona).setTitulo(titulo);

        return super.iniciarAlta(nombre, apellido, dni, fechaNacimiento, telefono,
                barrio, calle, numero, piso, departamanto, localidad, provincia, pais, sexo, cuil);
    }
}
