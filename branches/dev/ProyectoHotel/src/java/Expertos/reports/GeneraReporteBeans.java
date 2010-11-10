/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.reports;

import Expertos.reports.GeneraReporte;
import Tools.OpenFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Manuel
 */
@Stateless
public class GeneraReporteBeans implements GeneraReporte{

    private Connection _con;
    private Connection getConection(){
        if(_con != null) return _con;
        try{
            String urlConexion = "192.168.1.100:5432/hospitaltest"; //System.getProperties().getProperty("hibernate.connection.url");
            String usr ="postgres";// System.getProperties().getProperty("hibernate.connection.username");
            String pass = "postgres";//System.getProperties().getProperty("hibernate.connection.password");
            _con = DriverManager.getConnection(urlConexion, usr, pass);
        }catch(Exception ex){
            ex.printStackTrace();
            _con=null;
        }
        return _con;
    }

    public JasperPrint printReport(Map parametros, String xmlFile){

        try{
            return JasperFillManager.fillReport(JasperCompileManager.compileReport(OpenFile.openInputStream("/reports/"+xmlFile)), parametros,getConection());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
