/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.reports;

import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface GeneraReporte {

    public net.sf.jasperreports.engine.JasperPrint printReport(java.util.Map parametros, java.lang.String xmlFile);

    public net.sf.jasperreports.engine.JasperPrint printReport(java.util.Map parametros, java.lang.String xmlFile, net.sf.jasperreports.engine.JRDataSource datos);

}
