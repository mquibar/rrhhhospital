/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.gestionCategoria;

import Entidades.Categoria;
import Expertos.categorizacion.ExpAltaAgrupamiento;
import Expertos.categorizacion.ExpConsultarCategoria;
import Expertos.categorizacion.ExpModificarAgrupamiento;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import managerrrhhhospital.ContextGenerator;
import models.tables.TableAgrupamiento;
import models.tables.TableCategoria;
import models.tables.TableClaseContenida;
import models.tables.TableRequisitos;
import models.tables.TableTramo;

/**
 *
 * @author Manuel
 */
public class ctrlAdminEscalafon {

    private AdminEscalafon _pantalla;
    private ExpConsultarCategoria _gestorConsulta;
    private TableAgrupamiento _tablaAgrupamiento=null;
    private TableTramo _tablaTramo=null;
    private TableCategoria _tablaCategoria = null;
    private TableRequisitos _tablaRequisito = null;
    private TableClaseContenida _tablaClase = null;

    public ctrlAdminEscalafon() {
        _pantalla = new AdminEscalafon(this);
        _gestorConsulta = (ExpConsultarCategoria) ContextGenerator.getInstance().createGestor(ExpConsultarCategoria.class.getName());
        _tablaAgrupamiento = new TableAgrupamiento(_gestorConsulta.listarAgrupamientos());
        _pantalla.getTblAgrup().setModel(_tablaAgrupamiento);
        _pantalla.setVisible(true);
    }

    void filtrar() {
        _tablaAgrupamiento.filter(_pantalla.getTxtFilter().getText());
    }

    void listarTramo(){
        _tablaTramo = new TableTramo(_gestorConsulta.consultaTramo(_tablaAgrupamiento.getSelectedIndex(_pantalla.getTblAgrup().getSelectedRow())));
        _pantalla.getTblTramo().setModel(_tablaTramo);
    }

    void listarCategoria(){
        _tablaCategoria = new TableCategoria(_gestorConsulta.consultarCategoria(_tablaTramo.getSelectedIndex(_pantalla.getTblTramo().getSelectedRow())));
        _pantalla.getTblCateg().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarRequisitos(e);
            }
        });
        _pantalla.getTblCateg().setModel(_tablaCategoria);
    }

    private void mostrarRequisitos(MouseEvent e){
        Categoria c = _tablaCategoria.getSelectedIndex(_pantalla.getTblCateg().rowAtPoint(e.getPoint()));
        _tablaRequisito = new TableRequisitos(c.getRequisitoList());
        _pantalla.getTblRequ().setModel(_tablaRequisito);
        _tablaClase = new TableClaseContenida(c.getClaseContenida());
        _pantalla.getTblClass().setModel(_tablaClase);
    }

    void addAgrupamiento(){
        ExpAltaAgrupamiento gestor = (ExpAltaAgrupamiento) ContextGenerator.getInstance().createGestor(ExpAltaAgrupamiento.class.getName());
        gestor.guardarNuevo(_pantalla.getTxtAgrupamiento().getText());
        gestor =null;
    }

    void addTramo(){
        ExpModificarAgrupamiento gestor=(ExpModificarAgrupamiento) ContextGenerator.getInstance().createGestor(ExpModificarAgrupamiento.class.getName());
        gestor.agregarTramo(_tablaAgrupamiento.getSelectedIndex(_pantalla.getTblAgrup().getSelectedRow()), _pantalla.getTxtTramo().getText());
    }
}
