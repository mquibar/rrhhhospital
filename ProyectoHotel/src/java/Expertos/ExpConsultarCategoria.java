/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Agrupamiento;
import Entidades.Clase;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Desarrollo
 */
@Remote
@Local
public interface  ExpConsultarCategoria {

    public List<Entidades.Agrupamiento> listarAgrupamientos();
    
    public List<Clase> listarClases();

    public Entidades.Categoria consultarCategoriaByNombre(java.lang.String nombre);

    public Entidades.Agrupamiento consultarAgrupamientoByNombre(java.lang.String nombre);

    public Entidades.Tramo consultarTramoByNombre(Entidades.Agrupamiento agrupamiento, java.lang.String nombreTramo);
    public List<Entidades.Tramo> consultaTramo(Agrupamiento agrupamiento);
}
