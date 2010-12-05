/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.exception;

/**
 *
 * @author Manuel
 */
public class PersistenceException extends SystemException {

    public PersistenceException(Exception e) {
        super(4, "Error al realizar operaciones de base de datos, ERROR: "+e );
    }

    public PersistenceException(PersistenceException pe){
        super(4, pe.getMessage());
    }

}
