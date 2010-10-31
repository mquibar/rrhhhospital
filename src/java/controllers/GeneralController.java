package controllers;

import java.io.InputStream;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;


public class GeneralController {

    private Context _ctx = null;

    private void loadContext() {
        try {
            InputStream io = GeneralController.class.getResourceAsStream("/jndi.properties");
            Properties prop = new Properties();
            prop.load(io);
            _ctx = new InitialContext(prop);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param experto debe ser el nombre del experto que necesitamos crear
     * @return Este metodo sirve para crear los expertos que necesitamos.
     */
    protected Object getExpert(String experto) {
        if (_ctx == null) {
            loadContext();
        }
        try {
            return _ctx.lookup(experto);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
