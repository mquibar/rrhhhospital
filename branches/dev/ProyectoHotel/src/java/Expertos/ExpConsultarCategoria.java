/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Clase;
import Entidades.Tramo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
public interface  ExpConsultarCategoria {

    public List<Entidades.Agrupamiento> listarAgrupamientos();
    
    public List<Clase> listarClases();

    public Entidades.Categoria consultarCategoriaByNombre(java.lang.String nombre);

    public Entidades.Agrupamiento consultarAgrupamientoByNombre(java.lang.String nombre);

    public Entidades.Tramo consultarTramoByNombre(Entidades.Agrupamiento agrupamiento, java.lang.String nombreTramo);
    public List<Entidades.Tramo> consultaTramo(Agrupamiento agrupamiento);

    public List<Categoria> consultarCategoria(Tramo tramo);

    public List<Categoria> listarCategorias();
}
