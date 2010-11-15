/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Empleado;
import Entidades.RegistroPeriodo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
public interface  ExpConsultarRegistroPeriodo {

       
    public List<RegistroPeriodo> listar(Empleado empleado, int mes);

    public java.util.List<Entidades.RegistroPeriodo> listar();

    public java.util.List<Entidades.RegistroPeriodo> listar(Entidades.Empleado empleado);
}
