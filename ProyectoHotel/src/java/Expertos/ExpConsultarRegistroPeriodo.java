/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Agrupamiento;
import Entidades.Clase;
import Entidades.Empleado;
import Entidades.RegistroPeriodo;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
@Local
public interface  ExpConsultarRegistroPeriodo {

    public List<RegistroPeriodo> listar();
    
    public List<RegistroPeriodo> listar(Empleado empleado);

    public List<RegistroPeriodo> listar(Empleado empleado, int mes);
}
