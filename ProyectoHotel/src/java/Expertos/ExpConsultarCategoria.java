/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Agrupamiento;
import Entidades.Clase;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
public interface  ExpConsultarCategoria {

    public List<Agrupamiento> listarAgrupamientos();
    public List<Clase> listarClases();

    public Entidades.Categoria consultarCategoriaByNombre(java.lang.String nombre);
}
