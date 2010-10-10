/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Configuraciones;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Manuel
 */
public class loadConfig {

    public static void configurarConexion(){
        Properties p = new Properties();
        InputStream i = loadConfig.class.getResourceAsStream("/Configuraciones/coneccionproperties.properties");
        p = System.getProperties();
        try {
            p.load(i);
            System.out.println("Conexion= " + p.getProperty("hibernate.connection.url"));
        } catch (IOException ex) {
            System.out.println("Error");
        }
        System.setProperties(p);
    }
}
