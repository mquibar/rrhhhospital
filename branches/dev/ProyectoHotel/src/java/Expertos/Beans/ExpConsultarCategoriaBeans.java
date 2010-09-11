/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Agrupamiento;
import Expertos.ExpConsultarCategoria;
import Intermediarios.IntermediarioAgrupamiento;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Desarrollo
 */
@Stateless
public class ExpConsultarCategoriaBeans implements ExpConsultarCategoria {

    public List<Agrupamiento> listarAgrupamientos(){
        return (new IntermediarioAgrupamiento()).findInOrden("nombre");
    }
}
