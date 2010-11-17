/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import javax.ejb.Remote;

/**
 *
 * @author Juan
 */
@Remote
public interface ExpAsignarLegajo {

    public java.util.List<Entidades.Empleado> beginCU();

    public java.util.List<Entidades.Agrupamiento> listarAgrupamiento();

    public java.util.List<Entidades.Tramo> listarTramo(Entidades.Agrupamiento a);

    public java.util.List<Entidades.Categoria> listarCategoria(Entidades.Tramo t);

    public java.util.List<Entidades.Clase> listarClase(Entidades.Categoria c);

    public void saveEmployee(Entidades.Empleado e, Entidades.Categoria cat, Entidades.Clase cl, java.lang.Integer legajo) throws system.exception.SystemException;
    
}
