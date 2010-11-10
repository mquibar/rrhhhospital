/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Empleado;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Persona;
import Entidades.Provincia;
import Expertos.personal.ExpModificarPersona;
import models.tables.AbstractModelTable;
import models.tables.ModelTablaEmpleado;

/**
 *
 * @author MARIANO
 */
public class ctrlModificarEmpleado extends GeneralController{

    ExpModificarPersona _exp;
    AbstractModelTable<Empleado> _tabla;
    public ctrlModificarEmpleado() {
        _exp = (ExpModificarPersona) super.getExpert(ExpModificarPersona.class.getName());
    }

    public String crearTabla(){
        _tabla = new ModelTablaEmpleado(_exp.listarEmpleados());
        return _tabla.toString();
    }

    public Empleado getSelected(int Index){
        return _tabla.getRow(Index);
    }

    public String modificarDomicilioPersona (Persona persona, String barrio, String calle, String numero,
            String piso, String departamanto, Localidad localidad, Provincia provincia, Pais pais){

        

        return "";
    }
}
