/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.gestionCategoria;

import Entidades.ClaseContenida;
import Entidades.Requisito;
import Entidades.Tramo;
import Expertos.categorizacion.ExpAltaCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import managerrrhhhospital.ContextGenerator;
import models.tables.TableClase;
import models.tables.TableClaseContenida;
import models.tables.TableRequisitos;

/**
 *
 * @author Manuel
 */
public class ctrlAltaCategoria {

    private AltaCategoria _pantalla;
    private ExpAltaCategoria _gestorCategoria;
    private TableRequisitos _requisitos;
    private TableClase _clases;
    private TableClaseContenida _clasesContenidas;

    public ctrlAltaCategoria(AdminEscalafon pantalla, Tramo tramo) {
        _pantalla = new AltaCategoria(pantalla, this);
        _gestorCategoria = (ExpAltaCategoria) ContextGenerator.getInstance().createGestor(ExpAltaCategoria.class.getName());
        _clases = new TableClase(_gestorCategoria.iniciarCU(tramo));
        _clasesContenidas = new TableClaseContenida(new ArrayList<ClaseContenida>());
        _requisitos = new TableRequisitos(new ArrayList<Requisito>());

        _pantalla.getBtnAddRequisito().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressAddRequest();
            }
        });
        _pantalla.getBtnDelRequisito().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressRemoveRequest();
            }
        });

        _pantalla.getBtnAddOne().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressAddOne();
            }
        });
        _pantalla.getBtnAddAll().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressAddAll();
            }
        });

        _pantalla.getBtnRemoveOne().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressRemoveOne();
            }
        });
        _pantalla.getBtnRemoveAll().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressRemoveAll();
            }
        });

        _pantalla.getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressCancelButton();
            }
        });
        _pantalla.getBtnOk().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                pressOkButton();
            }
        });
        _pantalla.getTblRequisitos().setModel(_requisitos);
        _pantalla.getTblClases().setModel(_clases);
        _pantalla.getTblClasesAsignadas().setModel(_clasesContenidas);
        _pantalla.setVisible(true);
    }

    void pressCancelButton(){
        _pantalla.dispose();
    }

    void pressOkButton(){
        _gestorCategoria.setterRequisito(_requisitos.getAllRow());
    }

    void pressAddRequest(){
        Requisito r = new Requisito();
        r.setDescripcion("Nuevo Requisito");
        r.setNumero(_requisitos.getRowCount());
        _requisitos.addRow(r);
        _requisitos.sort();
        _pantalla.getTblRequisitos().editCellAt(_requisitos.getRowCount()-1, 1);
    }

    void pressRemoveRequest(){
        _requisitos.delRow(_pantalla.getTblRequisitos().getSelectedRow());
        _requisitos.sort();
    }

    void pressAddOne(){
        ClaseContenida cc = new ClaseContenida();
        cc.setAntiguedadMinima( Long.valueOf("0") );
//        Integer.MIN_VALUE)
//        _clasesContenidas.addRow(_clases.getSelectedIndex(_pantalla.getTblClases().getSelectedRow()));
        _clases.delRow(_pantalla.getTblClases().getSelectedRow());
        _clases.sort();
        _clasesContenidas.sort();
        boolean enabled = _clases.getRowCount()>0;
        _pantalla.getBtnAddAll().setEnabled(enabled);
        _pantalla.getBtnAddOne().setEnabled(enabled);
        _pantalla.getBtnRemoveOne().setEnabled(true);
        _pantalla.getBtnRemoveAll().setEnabled(true);
    }
    void pressAddAll(){
        //_clasesContenidas.addAll(_clases.getAllRow());
        _clases.clear();
        _clasesContenidas.sort();
        _pantalla.getBtnAddAll().setEnabled(false);
        _pantalla.getBtnAddOne().setEnabled(false);
        _pantalla.getBtnRemoveOne().setEnabled(true);
        _pantalla.getBtnRemoveAll().setEnabled(true);
    }

    void pressRemoveOne(){
        //_clases.addRow(_clasesContenidas.getSelectedIndex(_pantalla.getTblClasesAsignadas().getSelectedRow()));
        _clasesContenidas.delRow(_pantalla.getTblClasesAsignadas().getSelectedRow());
        _clasesContenidas.sort();
        _clases.sort();
        boolean enabled = _clasesContenidas.getRowCount()>0;
        _pantalla.getBtnAddAll().setEnabled(true);
        _pantalla.getBtnAddOne().setEnabled(true);
        _pantalla.getBtnRemoveOne().setEnabled(enabled);
        _pantalla.getBtnRemoveAll().setEnabled(enabled);
    }

    void pressRemoveAll(){
        //_clases.addAll(_clasesContenidas.getAllRow());
        _clasesContenidas.clear();
        _clases.sort();
        _pantalla.getBtnRemoveOne().setEnabled(false);
        _pantalla.getBtnRemoveAll().setEnabled(false);
        _pantalla.getBtnAddAll().setEnabled(true);
        _pantalla.getBtnAddOne().setEnabled(true);
    }
}


