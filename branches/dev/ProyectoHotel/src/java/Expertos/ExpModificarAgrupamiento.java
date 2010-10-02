/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface ExpModificarAgrupamiento {

    public java.util.List<Entidades.Agrupamiento> inicioModificacion();

    public boolean cambiarNombre(Entidades.Agrupamiento agrupamiento, java.lang.String nombre);

    public boolean agregarTramo(Entidades.Agrupamiento agrupamiento, java.lang.String nombreTramo);

}
