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
public abstract class SystemException extends Exception {

    private int errorCode;
    private String value;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SystemException(int errorCode, String value) {
        super("System Error Code: " + errorCode + " [" + value + "]");
        this.errorCode = errorCode;
        this.value = value;
    }
}
