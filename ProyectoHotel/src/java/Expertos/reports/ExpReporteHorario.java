/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.reports;

import Entidades.Empleado;
import java.util.Date;
import javax.ejb.Remote;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Administrador
 */
@Remote
public interface ExpReporteHorario {

    JasperPrint getReporte(Empleado emp, Date fini, Date ffin, String tipoReporte);

}
