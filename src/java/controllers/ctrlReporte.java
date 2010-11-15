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

    private Connection getConection() {
        if (_con != null) {
            return _con;
        }
        try {
            Class.forName("org.postgresql.Driver");
            String urlConexion = "jdbc:postgresql://192.168.7.190:5432/hospital"; //System.getProperties().getProperty("hibernate.connection.url");
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

    public ctrlReporte() {
//        _report = (GeneraReporte) getExpert(GeneraReporte.class.getName());
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
}
