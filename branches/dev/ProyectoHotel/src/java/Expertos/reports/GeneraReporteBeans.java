/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.reports;

import Tools.OpenFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

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
            Class.forName("org.postgresql.Driver").newInstance();
            String urlConexion = System.getProperties().getProperty("hibernate.connection.url");
            String usr = System.getProperties().getProperty("hibernate.connection.username");
            String pass = System.getProperties().getProperty("hibernate.connection.password");
            _con = DriverManager.getConnection(urlConexion, usr, pass);
        }catch(Exception ex){
            ex.printStackTrace();
            _con=null;
        }
        return _con;
    }

    public JasperPrint printReport(Map parametros, String xmlFile){

        try{
            return JasperFillManager.fillReport(JasperCompileManager.compileReport(OpenFile.openInputStream("/reports/"+xmlFile+".jrxml")), parametros,getConection());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public JasperPrint printReport(Map parametros, String xmlFile, JRDataSource datos){

        InputStream lis = null;

        try{
           String userdir = new File(".").getCanonicalPath();
           String fileName = "/reports/"+xmlFile+".jrxml";
           
            InputStream file = OpenFile.openInputStream(fileName);
            if(file == null)
            {
                System.out.println("No se pudo abrir " + fileName + " en " + userdir);
            }
            else
            {
                System.out.println("Encontrado " + fileName + " en " + userdir);
            }

            lis = new LegacyJasperInputStream(file);
            System.out.println("Stream compatible listo");
            //pq reportes generados con cliente nuevos se puedan leer con librerias viejas

        }catch(Exception ex){
            System.out.print("printReport: error en 1: " + ex.toString());
            ex.printStackTrace();
        }

        try{
            JasperDesign jd = JRXmlLoader.load(lis);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            return JasperFillManager.fillReport(jr, parametros,datos);
        }catch(Exception ex){
            System.out.print("printReport: error en 2: " + ex.toString());
            ex.printStackTrace();
        }

        return null;
    }
}
