/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Categoria;
import Entidades.Empleado;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Manuel
 */
public class ExpRecategorizacionBeans {

    @EJB
    Expertos.ExpConsultarCategoria _consultaCategorias;
    Expertos.ExpConsultarPersonal _consultaPersonal;

    public List<Empleado> iniciarRecategorizacion(){
        return _consultaPersonal.listarEmpleadoinOrder();
    }

    public List<Categoria> buscarCategoriasPosibles(Empleado e){
        return null;
    }
}
