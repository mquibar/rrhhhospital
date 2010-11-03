/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.GeneraReporte;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Manuel
 */
public class ctrlReporte extends GeneralController {

    private GeneraReporte _report;

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
            parametros.put("id", 1);
            System.out.println("D:\\Documentos\\NetBeansProjects\\ProyectoHotel\\src\\java\\reports\\"+xmlFile);
            InputStream io = ctrlReporte.class.getResourceAsStream("/reports/test.jrxml");
            System.out.println("abrio");
            JasperReport jp = JasperCompileManager.compileReport(io);
            System.out.println("@@@@@@@");
            return JasperFillManager.fillReport(jp, parametros,getConection());
        }catch(Exception ex){
            System.out.println("Error al abrir: " + ex.getMessage());
        }
        return null;
    }
    public ctrlReporte() {
//        _report = (GeneraReporte) getExpert(GeneraReporte.class.getName());
    }

    public void armarReporte(){
        try{
        JasperExportManager.exportReportToHtmlFile(printReport(new HashMap(), "test.jrxml"),"C:\\temp\\");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    
}
