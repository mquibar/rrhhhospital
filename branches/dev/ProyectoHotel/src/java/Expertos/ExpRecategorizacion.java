/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

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

}
