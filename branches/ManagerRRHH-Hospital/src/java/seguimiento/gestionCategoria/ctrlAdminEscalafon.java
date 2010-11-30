/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.gestionCategoria;

import Entidades.Categoria;
import Expertos.categorizacion.ExpAltaAgrupamiento;
import Expertos.categorizacion.ExpConsultarCategoria;
import Expertos.categorizacion.ExpModificarAgrupamiento;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        _pantalla.getTxtFilter().addKeyListener( new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                filtrar();
            }
        });
    }

    void filtrar() {
        _tablaAgrupamiento.filter(_pantalla.getTxtFilter().getText().toUpperCase());
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
        if(_pantalla.getTxtAgrupamiento().getText().isEmpty())
            return;
        
        if(((ExpAltaAgrupamiento) ContextGenerator.getInstance().createGestor(ExpAltaAgrupamiento.class.getName())).guardarNuevo(_pantalla.getTxtAgrupamiento().getText()))
            System.out.println(" guardado");
        else
            System.out.println("No Guardado");
    }

    void addTramo(){
        if(_pantalla.getTxtTramo().getText().isEmpty())
            return;
        ExpModificarAgrupamiento gestor=(ExpModificarAgrupamiento) ContextGenerator.getInstance().createGestor(ExpModificarAgrupamiento.class.getName());
        gestor.agregarTramo(_tablaAgrupamiento.getSelectedIndex(_pantalla.getTblAgrup().getSelectedRow()), _pantalla.getTxtTramo().getText());
    }
}
