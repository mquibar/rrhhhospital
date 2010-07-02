/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Configuraciones;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author desarrollo
 */
public class LogAdmin {

    private static LogAdmin _instance = null;

    public static LogAdmin getInstance(){
        if(_instance==null)
            _instance= new LogAdmin();
        return _instance;
    }

    public Log getLog(String cl){
        return LogFactory.getLog(cl);
    }
}
