/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.exception;

import javax.ejb.ApplicationException;


@ApplicationException(rollback=true)
public class InvalidDataException extends SystemException {
    private String field;
    private String badValue;

    public InvalidDataException(String field, String badValue) {
        super(1, "El campo: "+field+" contiene el valor invalido: "+badValue);
        this.field = field;
        this.badValue = badValue;
    }

    public String getBadValue() {
        return badValue;
    }

    public void setBadValue(String badValue) {
        this.badValue = badValue;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
