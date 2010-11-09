/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.exception;

import javax.ejb.ApplicationException;


@ApplicationException(rollback=true)
public class DuplicateKeyException extends SystemException {

    private String field;
    private String duplicatedValue;

    public DuplicateKeyException(String field, String value) {
        super(4, "The field "+field+" has a duplicated business key: "+value);
        this.field = field;
        this.duplicatedValue = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDuplicatedValue() {
        return duplicatedValue;
    }

    public void setDuplicatedValue(String duplicatedValue) {
        this.duplicatedValue = duplicatedValue;
    }
    
}
