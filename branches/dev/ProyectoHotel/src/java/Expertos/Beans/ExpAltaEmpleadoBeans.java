/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Empleado;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import Entidades.Sexo;
import Expertos.ExpAltaEmpleado;
import Intermediarios.IntermediarioEmpleado;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */
@Stateless
public class ExpAltaEmpleadoBeans extends ExpAltaPersonalBeans implements ExpAltaEmpleado {

    public ExpAltaEmpleadoBeans() {
        _persona = new Empleado();
    }

    public Map<String, List> iniciar(){
        Map<String,List> listas = new HashMap<String, List>();
        listas.put("TIPO", (new Intermediarios.IntermediarioTipoEmpleado()).findAll());
        listas.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        listas.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        listas.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return listas;
    }


    public void agregarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo Sexo, String cuil) {

        ((Empleado) _persona).setCuil(cuil);
        ((Empleado) _persona).setFechaIngreso(new Date());
        
        return super.iniciarAlta(nombre, apellido, dni, fechaNacimiento, telefono, barrio,
                calle, numero, piso, departamanto, localidad, provincia, pais, Sexo);
    }

    public boolean agregarLegajo(Empleado empleado, int legajo) {
        empleado.setLegajo(legajo);
        return (new IntermediarioEmpleado()).actualizar(empleado);
    }

}
