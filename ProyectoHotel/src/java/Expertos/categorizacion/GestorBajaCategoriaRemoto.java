/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.categorizacion;

import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface GestorBajaCategoriaRemoto {

    public void bajaCategoria(Entidades.Categoria categoria) throws system.exception.GenericException, system.exception.PersistenceException;

    public void bajaTramo(Entidades.Tramo tramo)throws system.exception.GenericException, system.exception.PersistenceException;

    public void bajaAgrupamiento(Entidades.Agrupamiento agrupamiento) throws system.exception.GenericException, system.exception.PersistenceException;
    
}
