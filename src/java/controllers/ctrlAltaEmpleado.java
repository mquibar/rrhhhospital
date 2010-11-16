/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import Entidades.Sexo;
import Entidades.Tarjeta;
import Entidades.TipoEmpleado;
import Expertos.personal.ExpAltaEmpleado;
import java.util.Date;

/**
 * Maneja el alta de empleado de manera particular
 * Le entregan los datos del nuevo empleado y el controlador
 * es el encargado de realizar la persistencia del mismo
 *
 * @author Juan
 */

public class ctrlAltaEmpleado extends GeneralController {

    private ExpAltaEmpleado exp;

    public ctrlAltaEmpleado() {
        exp = (ExpAltaEmpleado) super.getExpert(ExpAltaEmpleado.class.getName());

    }

    public String iniciarAlta(TipoEmpleado tipo,String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo sexo, String cuil, Tarjeta tarjeta) {
            
        try {

            if(exp.iniciarAlta(tipo,nombre,apellido,dni,fechaNacimiento,
                    telefono,barrio, calle,numero,piso,departamanto,localidad,
                    provincia, pais, sexo,cuil,tarjeta)){
                return "Empleado Guardado";

            } else {
                return "Error: Error al Guardar";

            }
        } catch (Exception ex) {
            return "Error: Error de conexion con servidor de aplicaciones"+ex.toString();
        }

    }

}
