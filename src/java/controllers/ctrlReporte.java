/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Expertos.reports.GeneraReporte;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
    private static JasperPrint _jsp;

    private Connection getConection() {
        if (_con != null) {
            return _con;
        }
        try {
            Class.forName("org.postgresql.Driver");
            String urlConexion = "jdbc:postgresql://localhost:5432/hospital"; //System.getProperties().getProperty("hibernate.connection.url");
            String usr = "postgres";// System.getProperties().getProperty("hibernate.connection.username");
            String pass = "postgres";//System.getProperties().getProperty("hibernate.connection.password");
            _con = DriverManager.getConnection(urlConexion, usr, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
            _con = null;
        }
        return _con;
    }

    public JasperPrint printReport(Map parametros, String xmlFile) {

        try {
            parametros.put("id", 1);
            System.out.println("/reports/" + xmlFile);
            InputStream io = ctrlReporte.class.getResourceAsStream("/reports/test.jrxml");
            System.out.println("abrio");
            JasperReport jp = JasperCompileManager.compileReport(io);
            System.out.println("@@@@@@@");
            return JasperFillManager.fillReport(jp, parametros, getConection());
        } catch (Exception ex) {
            System.out.println("Error al abrir: " + ex.getMessage());
        }
        return null;
    }

    private byte[] printErrorReport(){
        try{
            InputStream io = ctrlReporte.class.getResourceAsStream("/reports/ErrorReport.jrxml");
            JasperReport jp = JasperCompileManager.compileReport(io);
            return JasperExportManager.exportReportToPdf(JasperFillManager.fillReport(jp,null));
        }catch(Exception e)
        {return null;}
    }

    public ctrlReporte() {
//        _report = (GeneraReporte) getExpert(GeneraReporte.class.getName());
    }

    public static JasperPrint getJsp() {
        return _jsp;
    }

    public static void setJsp(JasperPrint jsp) {
        if(_jsp!=null)
            return;
        ctrlReporte._jsp = jsp;
    }

    public byte[] armarReporte(){
        if(_jsp == null)
            return null;
        try {
            byte[] report=JasperExportManager.exportReportToPdf(_jsp);
            _jsp=null;
            return report;
        } catch (Exception e) {
            _jsp = null;
            return printErrorReport();
        }
    }
    public byte[] armarReporte(String reporte) {
        try {
            _report = (GeneraReporte) super.getExpert(GeneraReporte.class.getName());

            return JasperExportManager.exportReportToPdf(_report.printReport(null, reporte));//printReport(new HashMap(), "test.jrxml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public byte[] armarReporte(Map parametros) {
        String reporte = (String) parametros.get("report");

        parametros.remove("report");
        try {
            _report = (GeneraReporte) super.getExpert(GeneraReporte.class.getName());
            return JasperExportManager.exportReportToPdf(_report.printReport(parametros, reporte));//printReport(new HashMap(), "test.jrxml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public byte[] armarReporte(JasperPrint jp) {
        byte[] rep = new byte[0];

        try {
            rep = JasperExportManager.exportReportToPdf(jp);//printReport(new HashMap(), "test.jrxml"));
            System.out.println("armarReporte: Reporte armado con exito");
        } catch (Exception e) {
            System.out.println("armarReporte: Error: " + e.getMessage());
        }

        return rep;
    }

}
