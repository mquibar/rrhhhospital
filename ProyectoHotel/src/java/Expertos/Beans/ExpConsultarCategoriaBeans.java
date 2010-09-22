/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import DTO.DtoAgrupamiento;
import DTO.DtoCategoria;
import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Clase;
import Entidades.Tramo;
import Expertos.ExpConsultarCategoria;
import Intermediarios.IntermediarioAgrupamiento;
import Intermediarios.IntermediarioCategoria;
import Intermediarios.IntermediarioClase;
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

    public List<Clase> listarClases() {
        return (new IntermediarioClase()).findAll();
    }

    public Categoria consultarCategoriaByNombre(String nombre){
        IntermediarioCategoria intermediario = new IntermediarioCategoria();
        Categoria categoria;
        DtoCategoria dto = new DtoCategoria();
        dto.setNombre(nombre);
        try {
            categoria = intermediario.findByDto(dto).get(0);
        } catch (NullPointerException e) {
            categoria=null;
        }
        dto=null;
        intermediario=null;
        return categoria;
    }

    public Agrupamiento consultarAgrupamientoByNombre(String nombre){
        DtoAgrupamiento dto = new DtoAgrupamiento(nombre);
        try{
            return (new IntermediarioAgrupamiento()).findByDto(dto).get(0);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
    }

    public Tramo consultarTramoByNombre(String nombreTramo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}