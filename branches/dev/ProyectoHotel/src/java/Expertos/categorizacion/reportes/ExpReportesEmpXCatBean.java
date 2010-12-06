/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.categorizacion.reportes;

import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Tramo;
import Expertos.categorizacion.ExpConsultarCategoria;
import Expertos.reports.GeneraReporte;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author desarrollo
 */
@Stateless
public class ExpReportesEmpXCatBean implements ExpReportesEmpXCatRemote {
    
    @EJB
    ExpConsultarCategoria _consultas;
    @EJB
    GeneraReporte _reportes;

    public List<Agrupamiento> listarAgrupamiento(){
        return _consultas.listarAgrupamientos();
    }

    public List<Tramo> listarTramo(Agrupamiento a){
        return _consultas.consultaTramo(a);
    }

    public List<Categoria> listarCategorias(Tramo t){
        return _consultas.consultarCategoria(t);
    }

    public JasperPrint generarReporte(){
        return _reportes.printReport(null, "empleadoCategoria");
    }

    public JasperPrint generarReporte(Categoria c){
        Map param = new HashMap();
        param.put("p_id", c.getId());
        return _reportes.printReport(param, "empleadoCategoriaEspecifica");
    }

    public JasperPrint generarReporteRequisitos(Categoria c){
        Map param = new HashMap();
        param.put("p_id", c.getId());
        return _reportes.printReport(param, "empleadoCategoriaEspecifica");
    }
}
