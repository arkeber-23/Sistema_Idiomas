/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CursoDao;
import controlador.DocenteDao;
import controlador.NotaDao;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.Docente;
import modelo.Nota;

public class frmNota extends javax.swing.JInternalFrame {

    DocenteDao docenteDao = new DocenteDao();
    NotaDao notaDao = new NotaDao();
    CursoDao cursoDao = new CursoDao();

    public frmNota() {
        initComponents();
        docenteDao.listarCombo(cmbDocente);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbDocente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Notas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout());

        tblRegistro.setBackground(new java.awt.Color(255, 255, 255));
        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Estudiante", "Estudiante", "Calificación"
            }
        ));
        jScrollPane2.setViewportView(tblRegistro);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1070, 390));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Docente: ");

        cmbDocente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDocenteItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Curso:");

        cmbCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCursoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(116, 116, 116))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 370, 130));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 141, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/not.png"))); // NOI18N
        jLabel3.setText("Registro Notas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 230, 110));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        //Insertar Datos     
        for (int i = 0; i < tblRegistro.getRowCount(); i++) {//recorre las filas en la tabla
            int idEstudiante = Integer.parseInt(tblRegistro.getValueAt(i, 0).toString());
            int idDocente = cmbDocente.getItemAt(cmbDocente.getSelectedIndex()).getIdDocente();
            int idCurso = cmbCurso.getItemAt(cmbCurso.getSelectedIndex()).getIdCurso();
            double nota = Double.parseDouble(tblRegistro.getValueAt(i, 2).toString());
            Nota n = new Nota(idEstudiante, idDocente, idCurso, nota);
            notaDao.insertarNotas(n);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCursoItemStateChanged
        // TODO add your handling code here:

        DefaultTableModel dtm = (DefaultTableModel) tblRegistro.getModel();
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int idDocente = cmbDocente.getItemAt(cmbDocente.getSelectedIndex()).getIdDocente();
            String nivel = cmbCurso.getSelectedItem().toString();
            List<Nota> ingresarNotasEstudiantes = notaDao.listarEstudianteAula(idDocente, nivel);
            dtm.setRowCount(0);
            Object[] fila;
            for (Nota ingresarNotasEstudiante : ingresarNotasEstudiantes) {

                fila = new Object[]{ingresarNotasEstudiante.getIdEstudinate(),
                    ingresarNotasEstudiante.getNombre(), ingresarNotasEstudiante.getNota()};
                dtm.addRow(fila);

            }
        }


    }//GEN-LAST:event_cmbCursoItemStateChanged

    private void cmbDocenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDocenteItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int idDocente = cmbDocente.getItemAt(cmbDocente.getSelectedIndex()).getIdDocente();
            cursoDao.listarComboNiveles(cmbCurso, idDocente);
        }
    }//GEN-LAST:event_cmbDocenteItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Curso> cmbCurso;
    private javax.swing.JComboBox<Docente> cmbDocente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRegistro;
    // End of variables declaration//GEN-END:variables
}
