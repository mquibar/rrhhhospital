/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguimiento.gestionCategoria;

import Entidades.Categoria;
import Expertos.categorizacion.ExpAltaAgrupamiento;
import Expertos.categorizacion.ExpConsultarCategoria;
import Expertos.categorizacion.ExpModificarAgrupamiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
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
    private TableAgrupamiento _tablaAgrupamiento = null;
    private TableTramo _tablaTramo = null;
    private TableCategoria _tablaCategoria = null;
    private TableRequisitos _tablaRequisito = null;
    private TableClaseContenida _tablaClase = null;
    private MousePanelCategoria _menuCategoria = null;
    private JDesktopPane _panelPrincipal;

    public ctrlAdminEscalafon(JDesktopPane panelPrincipal) {
        _panelPrincipal=panelPrincipal;
        _pantalla = new AdminEscalafon(this);
        _menuCategoria = new MousePanelCategoria(_pantalla, this);
        _gestorConsulta = (ExpConsultarCategoria) ContextGenerator.getInstance().createGestor(ExpConsultarCategoria.class.getName());
        _tablaAgrupamiento = new TableAgrupamiento(_gestorConsulta.listarAgrupamientos());
        _pantalla.getTblAgrup().setModel(_tablaAgrupamiento);
        _pantalla.setVisible(true);
        _pantalla.getTxtFilter().addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                filtrar();
            }

            public void keyPressed(KeyEvent e) {
                filtrar();
            }

            public void keyReleased(KeyEvent e) {
                filtrar();
            }

            private void filtrar() {
                _tablaAgrupamiento.filter(_pantalla.getTxtFilter().getText().toUpperCase());
            }
        });

        _pantalla.getBtnTramoView().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                listarCategoria();
            }
        });
        _pantalla.getPnlCategoria().addMouseListener(_menuCategoria);
        _pantalla.getTblCateg().addMouseListener(_menuCategoria);
        _panelPrincipal.add(_pantalla);
    }

    void listarTramo() {
        _tablaTramo = new TableTramo(_gestorConsulta.consultaTramo(_tablaAgrupamiento.getSelectedIndex(_pantalla.getTblAgrup().getSelectedRow())));
        _pantalla.getTblTramo().setModel(_tablaTramo);

    }

    void listarCategoria() {
        boolean flag = _pantalla.getPnlCategoria().isVisible();
        _pantalla.getPnlCategoria().setVisible(!flag);
        _pantalla.getBtnTramoAdd().setEnabled(flag);
        _pantalla.getBtnTramoDel().setEnabled(flag);
        if (!flag) {
            _pantalla.getPnlAddTramo().setVisible(flag);
            _pantalla.getBtnTramoView().setText("Ocultar Categorías");
            _pantalla.getBtnAgrupView().setEnabled(flag);
            _tablaCategoria = new TableCategoria(_gestorConsulta.consultarCategoria(_tablaTramo.getSelectedIndex(_pantalla.getTblTramo().getSelectedRow())));
            _pantalla.getTblCateg().setModel(_tablaCategoria);
        } else {
            _pantalla.getBtnTramoView().setText("Ver Categorías");
            _pantalla.getBtnAgrupView().setEnabled(flag);
        }
    }

    void mostrarRequisitos(MouseEvent e) {
        Categoria c = _tablaCategoria.getSelectedIndex(_pantalla.getTblCateg().rowAtPoint(e.getPoint()));
        _tablaRequisito = new TableRequisitos(_gestorConsulta.listarRequisitos(c));
        _pantalla.getTblRequ().setModel(_tablaRequisito);
        _tablaClase = new TableClaseContenida(c.getClaseContenida());
        _pantalla.getTblClass().setModel(_tablaClase);
    }

    void addAgrupamiento() {
        if (_pantalla.getTxtAgrupamiento().getText().isEmpty()) {
            return;
        }

        if (((ExpAltaAgrupamiento) ContextGenerator.getInstance().createGestor(ExpAltaAgrupamiento.class.getName())).guardarNuevo(_pantalla.getTxtAgrupamiento().getText())) {
            System.out.println(" guardado");
        } else {
            System.out.println("No Guardado");
        }
    }

    void addTramo() {
        if (_pantalla.getTxtTramo().getText().isEmpty()) {
            return;
        }
        ExpModificarAgrupamiento gestor = (ExpModificarAgrupamiento) ContextGenerator.getInstance().createGestor(ExpModificarAgrupamiento.class.getName());
        gestor.agregarTramo(_tablaAgrupamiento.getSelectedIndex(_pantalla.getTblAgrup().getSelectedRow()), _pantalla.getTxtTramo().getText());
    }

    void addCategoria() {
        new ctrlAltaCategoria( _tablaTramo.getSelectedIndex(_pantalla.getTblCateg().getSelectedRow()),_panelPrincipal);
    }
}

class MousePanelCategoria extends MouseAdapter {

    private JPopupMenu _menu;
    private JMenuItem _mnuAdd;
    private AdminEscalafon _pantalla;
    private ctrlAdminEscalafon _control;

    public MousePanelCategoria(AdminEscalafon pantalla, ctrlAdminEscalafon control) {
        _menu = new JPopupMenu("Menu Categorías");
        _mnuAdd = new JMenuItem("Agregar");
        _mnuAdd.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                _control.addCategoria();
            }
        });
        _menu.add(_mnuAdd);
        _menu.addSeparator();
        _mnuAdd = new JMenuItem("Eliminar");
        _menu.add(_mnuAdd);
        _pantalla = pantalla;
        _control = control;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        checkButton(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        checkButton(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        checkButton(e);
    }

    private void checkButton(MouseEvent e) {
        if (e.isPopupTrigger()) {
            _menu.show(_pantalla.getTblCateg(), e.getX(), e.getY());
        } else if (e.getButton() == MouseEvent.BUTTON1) {
            _control.mostrarRequisitos(e);
        }
    }
}

