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
import Expertos.personal.ExpAltaProfesional;
import java.util.Date;

/**
 * Maneja el alta de profesional de manera particular
 * Le entregan los datos del nuevo profesional y el controlador
 * es el encargado de realizar la persistencia del mismo
 *
 * @author Juan
 */
public class ctrlAltaProfesional extends GeneralController {

    private ExpAltaProfesional exp;

    public ctrlAltaProfesional() {
        exp = (ExpAltaProfesional) super.getExpert(ExpAltaProfesional.class.getName());

    }

    public boolean iniciarAlta(TipoEmpleado tipo, String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso,
            String departamanto, Localidad localidad, Provincia provincia, Pais pais, Sexo sexo,
            String cuil, String matricula, String titulo, Tarjeta tarjeta) throws Exception {
      
            if(exp.iniciarAlta(tipo,nombre,apellido,dni,fechaNacimiento,
                    telefono,barrio, calle,numero,piso,departamanto,localidad,
                    provincia, pais, sexo,cuil,matricula,titulo,tarjeta)){
                return true;
                
            } else {
                return false;
            }
    }

}
