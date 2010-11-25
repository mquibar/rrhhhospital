/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package managerrrhhhospital;

import java.io.InputStream;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Manuel
 */
public class ContextGenerator {

    private static ContextGenerator _instance=null;

    private ContextGenerator() {
    }

    public static ContextGenerator getInstance() {
        if(_instance == null)
            _instance = new ContextGenerator();
        return _instance;
    }


    public Object createGestor(String experto) {
        try {
            InputStream io = ContextGenerator.class.getResourceAsStream("/jndi.properties");
            Properties prop = new Properties();
            prop.load(io);
            Context c = new InitialContext(prop);
            return c.lookup(experto);
        } catch (Exception ne) {
            System.out.println("##########333"+ne.getMessage());
            ne.printStackTrace();
            return null;
        }
    }

}
