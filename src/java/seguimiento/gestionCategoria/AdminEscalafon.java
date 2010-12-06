/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminEscalafon.java
 *
 * Created on 22-nov-2010, 17:33:40
 */

package seguimiento.gestionCategoria;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Manuel
 */
public class AdminEscalafon extends javax.swing.JInternalFrame {

    /** Creates new form AdminEscalafon */
    public AdminEscalafon(ctrlAdminEscalafon control) {
        initComponents();
        _control=control;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        _txtFilter = new javax.swing.JTextField();
        _scrlAgrupamiento = new javax.swing.JScrollPane();
        _tblAgrup = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        _btnAgrupAdd = new javax.swing.JButton();
        _btnAgrupDel = new javax.swing.JButton();
        _btnAgrupView = new javax.swing.JButton();
        _pnlAddAgrup = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        _txtAgrupamiento = new javax.swing.JTextField();
        _btnAgrupOk = new javax.swing.JButton();
        _btnAgrupCancel = new javax.swing.JButton();
        _pnlTramo = new javax.swing.JPanel();
        _scrTramo = new javax.swing.JScrollPane();
        _tblTramo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        _btnTramoAdd = new javax.swing.JButton();
        _btnTramoDel = new javax.swing.JButton();
        _btnTramoView = new javax.swing.JButton();
        _pnlAddTramo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        _txtTramo = new javax.swing.JTextField();
        _btnTramoOk = new javax.swing.JButton();
        _btnTramoCancel = new javax.swing.JButton();
        _pnlCategoria = new javax.swing.JPanel();
        _scrCategoria = new javax.swing.JScrollPane();
        _tblCateg = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        _tblRequ = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        _tblClass = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray), "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Escalafon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.0010;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(_txtFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        _tblAgrup.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray));
        _tblAgrup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Agrupamiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _scrlAgrupamiento.setViewportView(_tblAgrup);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.0010;
        gridBagConstraints.weighty = 2.0;
        getContentPane().add(_scrlAgrupamiento, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        _btnAgrupAdd.setText("add");
        _btnAgrupAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnAgrupAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(_btnAgrupAdd, gridBagConstraints);

        _btnAgrupDel.setText("del");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(_btnAgrupDel, gridBagConstraints);

        _btnAgrupView.setText("Ver Tramos");
        _btnAgrupView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnAgrupViewActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(_btnAgrupView, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel2, gridBagConstraints);

        _pnlAddAgrup.setVisible(false);
        _pnlAddAgrup.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray));
        _pnlAddAgrup.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _pnlAddAgrup.add(jLabel2, gridBagConstraints);

        _txtAgrupamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _txtAgrupamientoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _pnlAddAgrup.add(_txtAgrupamiento, gridBagConstraints);

        _btnAgrupOk.setText("ok");
        _btnAgrupOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnAgrupOkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _pnlAddAgrup.add(_btnAgrupOk, gridBagConstraints);

        _btnAgrupCancel.setText("cancel");
        _btnAgrupCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnAgrupCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _pnlAddAgrup.add(_btnAgrupCancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(_pnlAddAgrup, gridBagConstraints);

        _pnlTramo.setVisible(false);
        _pnlTramo.setLayout(new java.awt.GridBagLayout());

        _tblTramo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tramo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        _scrTramo.setViewportView(_tblTramo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.0010;
        gridBagConstraints.weighty = 0.2;
        _pnlTramo.add(_scrTramo, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        _btnTramoAdd.setText("add");
        _btnTramoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnTramoAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(_btnTramoAdd, gridBagConstraints);

        _btnTramoDel.setText("del");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(_btnTramoDel, gridBagConstraints);

        _btnTramoView.setText("Ver Categor�as");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(_btnTramoView, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        _pnlTramo.add(jPanel3, gridBagConstraints);

        _pnlAddTramo.setVisible(false);
        _pnlAddTramo.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray));
        _pnlAddTramo.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _pnlAddTramo.add(jLabel3, gridBagConstraints);

        _txtTramo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _txtTramoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _pnlAddTramo.add(_txtTramo, gridBagConstraints);

        _btnTramoOk.setText("ok");
        _btnTramoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnTramoOkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _pnlAddTramo.add(_btnTramoOk, gridBagConstraints);

        _btnTramoCancel.setText("cancel");
        _btnTramoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnTramoCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _pnlAddTramo.add(_btnTramoCancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        _pnlTramo.add(_pnlAddTramo, gridBagConstraints);

        _pnlCategoria.setVisible(false);
        _pnlCategoria.setLayout(new java.awt.GridBagLayout());

        _scrCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray));

        _tblCateg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N�mero", "Categor�a", "Cupo"
            }
        ));
        _scrCategoria.setViewportView(_tblCateg);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.01;
        _pnlCategoria.add(_scrCategoria, gridBagConstraints);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray), "Requisitos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N

        _tblRequ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(_tblRequ);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.5;
        _pnlCategoria.add(jScrollPane4, gridBagConstraints);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray), "Clases", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N

        _tblClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(_tblClass);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        _pnlCategoria.add(jScrollPane5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.01;
        _pnlTramo.add(_pnlCategoria, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.01;
        getContentPane().add(_pnlTramo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _btnAgrupAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnAgrupAddActionPerformed
        _pnlAddAgrup.setVisible(true);
    }//GEN-LAST:event__btnAgrupAddActionPerformed

    private void _btnAgrupViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnAgrupViewActionPerformed
        detallesAgrupamiento();
    }//GEN-LAST:event__btnAgrupViewActionPerformed

    private void _btnTramoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnTramoAddActionPerformed
        _pnlAddTramo.setVisible(true);
    }//GEN-LAST:event__btnTramoAddActionPerformed

    private void _txtAgrupamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__txtAgrupamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__txtAgrupamientoActionPerformed

    private void _btnAgrupCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnAgrupCancelActionPerformed
        _pnlAddAgrup.setVisible(false);
    }//GEN-LAST:event__btnAgrupCancelActionPerformed

    private void _btnAgrupOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnAgrupOkActionPerformed
        _control.addAgrupamiento();
    }//GEN-LAST:event__btnAgrupOkActionPerformed

    private void _txtTramoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__txtTramoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__txtTramoActionPerformed

    private void _btnTramoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnTramoOkActionPerformed
        _control.addTramo();
    }//GEN-LAST:event__btnTramoOkActionPerformed

    private void _btnTramoCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnTramoCancelActionPerformed
        _pnlAddTramo.setVisible(false);
    }//GEN-LAST:event__btnTramoCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnAgrupAdd;
    private javax.swing.JButton _btnAgrupCancel;
    private javax.swing.JButton _btnAgrupDel;
    private javax.swing.JButton _btnAgrupOk;
    private javax.swing.JButton _btnAgrupView;
    private javax.swing.JButton _btnTramoAdd;
    private javax.swing.JButton _btnTramoCancel;
    private javax.swing.JButton _btnTramoDel;
    private javax.swing.JButton _btnTramoOk;
    private javax.swing.JButton _btnTramoView;
    private javax.swing.JPanel _pnlAddAgrup;
    private javax.swing.JPanel _pnlAddTramo;
    private javax.swing.JPanel _pnlCategoria;
    private javax.swing.JPanel _pnlTramo;
    private javax.swing.JScrollPane _scrCategoria;
    private javax.swing.JScrollPane _scrTramo;
    private javax.swing.JScrollPane _scrlAgrupamiento;
    private javax.swing.JTable _tblAgrup;
    private javax.swing.JTable _tblCateg;
    private javax.swing.JTable _tblClass;
    private javax.swing.JTable _tblRequ;
    private javax.swing.JTable _tblTramo;
    private javax.swing.JTextField _txtAgrupamiento;
    private javax.swing.JTextField _txtFilter;
    private javax.swing.JTextField _txtTramo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
    private ctrlAdminEscalafon _control;

    public JTable getTblAgrup() {
        return _tblAgrup;
    }

    public JTable getTblCateg() {
        return _tblCateg;
    }

    public JTable getTblClass() {
        return _tblClass;
    }

    public JTable getTblRequ() {
        return _tblRequ;
    }

    public JTable getTblTramo() {
        return _tblTramo;
    }

    public JTextField getTxtFilter() {
        return _txtFilter;
    }

    public JTextField getTxtAgrupamiento() {
        return _txtAgrupamiento;
    }

    public JTextField getTxtTramo() {
        return _txtTramo;
    }


    private void detallesAgrupamiento(){
        if(_tblAgrup.getSelectedRow()<0)
            return;
        boolean flag = _pnlTramo.isVisible();
        _pnlTramo.setVisible(!flag);
        _btnAgrupAdd.setEnabled(flag);
        _btnAgrupDel.setEnabled(flag);
        _tblAgrup.setEnabled(flag);
        _txtFilter.setEnabled(flag);
        if(!flag){
            _pnlAddAgrup.setVisible(flag);
            _btnAgrupView.setText("Ocultar Tramos");
            _control.listarTramo();
        }
        else
            ((models.tables.AbstractTable)_tblTramo.getModel()).clear();
            _btnAgrupView.setText("Ver Tramos");
    }

    public JButton getBtnAgrupAdd() {
        return _btnAgrupAdd;
    }

    public JButton getBtnAgrupCancel() {
        return _btnAgrupCancel;
    }

    public JButton getBtnAgrupDel() {
        return _btnAgrupDel;
    }

    public JButton getBtnAgrupOk() {
        return _btnAgrupOk;
    }

    public JButton getBtnAgrupView() {
        return _btnAgrupView;
    }

    public JButton getBtnTramoAdd() {
        return _btnTramoAdd;
    }

    public JButton getBtnTramoCancel() {
        return _btnTramoCancel;
    }

    public JButton getBtnTramoDel() {
        return _btnTramoDel;
    }

    public JButton getBtnTramoOk() {
        return _btnTramoOk;
    }

    public JButton getBtnTramoView() {
        return _btnTramoView;
    }

    public JPanel getPnlAddAgrup() {
        return _pnlAddAgrup;
    }

    public JPanel getPnlAddTramo() {
        return _pnlAddTramo;
    }

    public JPanel getPnlCategoria() {
        return _pnlCategoria;
    }

    public JPanel getPnlTramo() {
        return _pnlTramo;
    }

    public JScrollPane getScrCategoria() {
        return _scrCategoria;
    }

    public JScrollPane getScrTramo() {
        return _scrTramo;
    }

    public JScrollPane getScrlAgrupamiento() {
        return _scrlAgrupamiento;
    }

    
}
