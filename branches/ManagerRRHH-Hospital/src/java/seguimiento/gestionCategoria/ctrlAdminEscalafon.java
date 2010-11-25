/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.gestionCategoria;

import Expertos.categorizacion.ExpConsultarCategoria;
import managerrrhhhospital.ContextGenerator;
import models.tables.TableAgrupamiento;

/**
 *
 * @author Manuel
 */
public class ctrlAdminEscalafon {

    private AdminEscalafon _pantalla;
    private ExpConsultarCategoria _gestorConsulta;
    private TableAgrupamiento _tablaAgrupamiento;

    public ctrlAdminEscalafon() {
        _pantalla = new AdminEscalafon(this);
        //_gestorConsulta = (ExpConsultarCategoria) ContextGenerator.getInstance().createGestor(ExpConsultarCategoria.class.getName());
        //_tablaAgrupamiento = new TableAgrupamiento(_gestorConsulta.listarAgrupamientos());
        //_pantalla.getTblAgrup().setModel(_tablaAgrupamiento);
        _pantalla.setVisible(true);
    }

    void filtrar() {
        //_tablaAgrupamiento.filter(_pantalla.getTxtFilter().getText());
    }


    
}
