/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.reports;

import Entidades.Empleado;
import Expertos.horario.consultar.ExpConsultarAsignacionHorarioBeans;
import Expertos.horario.consultar.ExpConsultarLicenciaBeans;
import Expertos.horario.consultar.ExpConsultarRegistroPeriodoBeans;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Administrador
 */
@Stateless
public class ExpReporteHorarioImpl implements ExpReporteHorario
{
    private enum operaciones {
        Cronograma_Asignado_por_Empleado,
        Informe_de_Asistencia_por_Empleado,
        Licencias_Concedidas_a_Empleado}

    public JasperPrint getReporte(Empleado emp, Date fini, Date ffin, String tipoReporte)
    {
        List ent = null;
        JRDataSource ds = null;
        String xmlReporte = "";

        System.out.println("Iniciando reporte para " + tipoReporte);
        switch (operaciones.valueOf(tipoReporte)) {
            case Cronograma_Asignado_por_Empleado:
                ent = new ExpConsultarAsignacionHorarioBeans().informeCronograma(emp, fini,ffin);
                ds = new CronogramaReportDS(ent);
                xmlReporte = "asignacionHorario";
                break;

            case Informe_de_Asistencia_por_Empleado:
                ent = new ExpConsultarRegistroPeriodoBeans().informeAsistencia(emp, fini,ffin);
                ds = new AsistenciaReportDS(ent);
                xmlReporte = "registroPeriodo";
                break;

            case Licencias_Concedidas_a_Empleado:
                ent = new ExpConsultarLicenciaBeans().informeLicencias(emp, fini,ffin);
                ds = new LicenciaReportDS(ent);
                xmlReporte = "licencia";
                break;
        }

        System.out.println("Generando reporte");
        JasperPrint jp = new GeneraReporteBeans().printReport(null, xmlReporte, ds);

        return jp;
    }


}
