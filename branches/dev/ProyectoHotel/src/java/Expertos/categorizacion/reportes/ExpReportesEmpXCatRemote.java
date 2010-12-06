/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.categorizacion.reportes;

import javax.ejb.Remote;

/**
 *
 * @author desarrollo
 */
@Remote
public interface ExpReportesEmpXCatRemote {

    public java.util.List<Entidades.Agrupamiento> listarAgrupamiento();

    public java.util.List<Entidades.Tramo> listarTramo(Entidades.Agrupamiento a);

    public java.util.List<Entidades.Categoria> listarCategorias(Entidades.Tramo t);

    public net.sf.jasperreports.engine.JasperPrint generarReporte();

    public net.sf.jasperreports.engine.JasperPrint generarReporte(Entidades.Categoria c);
    public net.sf.jasperreports.engine.JasperPrint generarReporteRequisitos(Entidades.Categoria c);
    
}
