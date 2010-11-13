/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos.categorizacion;

import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Empleado;
import Entidades.Tramo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author MARIANO
 */
@Remote
public interface ExpRecategorizacion {

    public java.util.List<Entidades.Empleado> iniciarRecategorizacion();

    public java.util.List<Entidades.Categoria> buscarCategoriasPosibles(Entidades.Empleado e);

    public java.util.List<Entidades.Categoria> listarTodas();

    public boolean recategorizar(Entidades.Categoria categoria, Entidades.Clase clase, boolean cumpleRequerimientos);

    public List<Agrupamiento> listarAgrupamientos();
    public List<Tramo> listarTramo(Agrupamiento agrupamiento);
    public List<Categoria> listarCategoria(Empleado e, Tramo t);
    public List<Categoria> listarCategoria(Tramo t);
}
