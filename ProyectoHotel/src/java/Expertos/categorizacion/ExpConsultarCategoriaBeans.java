/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.categorizacion;

import DTO.DtoAgrupamiento;
import DTO.DtoCategoria;
import DTO.DtoTramo;
import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Clase;
import Entidades.Tramo;
import Intermediarios.IntermediarioAgrupamiento;
import Intermediarios.IntermediarioCategoria;
import Intermediarios.IntermediarioClase;
import Intermediarios.IntermediarioTramo;
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
        } catch (Exception e) {
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
            System.out.println("************************** El consultar Devolvio Null");
            return null;
        }
        
    }

    public Tramo consultarTramoByNombre(Agrupamiento agrupamiento, String nombreTramo) {
        DtoTramo dto = new DtoTramo();
        dto.setAgrupamiento(agrupamiento);
        dto.setNombre(nombreTramo);
        try{
            return (new IntermediarioTramo()).findByDto(dto).get(0);
        }catch(Exception ex){
            System.out.println("************** La consulta no encuentra tramos");
            return null;
        }
    }

    public List<Tramo> consultaTramo(Agrupamiento agrupamiento){
        DtoTramo dto = new DtoTramo();
        dto.setAgrupamiento(agrupamiento);
        try{
            return (new IntermediarioTramo()).findByDto(dto);
        }catch(Exception e){
            return null;
        }
    }

    public List<Categoria> consultarCategoria(Tramo tramo) {
        DtoCategoria dto = new DtoCategoria();
        dto.setTramo(tramo);
        try{
            return (new IntermediarioCategoria()).findByDto(dto);
        }catch(Exception ex){
            return null;
        }
    }

    public List<Categoria> listarCategorias() {
        return (new IntermediarioCategoria()).findAll();
    }

    public Categoria consultarCategoria(Categoria categoria) {
        return (new IntermediarioCategoria()).findById(categoria);
    }

    public Tramo consultarTramo(Categoria categoria) {
        DtoTramo dto = new DtoTramo();
        dto.setCategoria(categoria);
        try{
            return (new IntermediarioTramo()).findByDto(dto).get(0);
        }catch(Exception ex){
            return null;
        }
    }

}
