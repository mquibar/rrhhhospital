/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Manuel
 */
@ApplicationException(rollback = true)
public class GenericException extends SystemException {

    public GenericException(String message) {
        super(3, message);
    }
   
}
