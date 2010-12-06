/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Categoria;
import Expertos.categorizacion.reportes.ExpReportesEmpXCatRemote;
import java.util.Map;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionAgrupamiento;
import models.combos.ModelOptionCategoria;
import models.combos.ModelOptionTramo;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author desarrollo
 */
public class ctrlReporteEmpCat extends GeneralController {

    private ExpReportesEmpXCatRemote _exp;
    private ModelOptionAgrupamiento _modAgrupamiento;
    private ModelOptionTramo _modTramo;
    private ModelOptionCategoria _modCategoria;

    public ctrlReporteEmpCat() {
        _exp = (ExpReportesEmpXCatRemote) super.getExpert(ExpReportesEmpXCatRemote.class.getName());
    }

    public AbstractModelOptionList listarAgrupamientos() {
        _modAgrupamiento = new ModelOptionAgrupamiento(_exp.listarAgrupamiento());
        return _modAgrupamiento;
    }

    public AbstractModelOptionList listarTramo(String Index) {
        _modTramo = new ModelOptionTramo(_exp.listarTramo(_modAgrupamiento.getSelectedItem(Index)));
        return _modTramo;
    }

    public AbstractModelOptionList listarCategorias(String IndexTramo) {
        _modCategoria = new ModelOptionCategoria(_exp.listarCategorias(_modTramo.getSelectedItem(IndexTramo)));
        return _modCategoria;
    }

    public String armarReporte(){
        return "empleadoCategoria";
    }

    public String armarReporte(String IndexCategoria){
        Categoria c = _modCategoria.getSelectedItem(IndexCategoria);
        return "empleadoCategoriaEspecifica&p_id="+c.getId();
    }

    public void verReportes(){
        JasperViewer.viewReport(_exp.generarReporte());
    }

    public void verReportes(String IndexCategoria){
        Categoria c = _modCategoria.getSelectedItem(IndexCategoria);
        if(c== null) return;
        JasperViewer.viewReport(_exp.generarReporte(c));
    }

}
