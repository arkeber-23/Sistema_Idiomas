package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class frmPricipal extends javax.swing.JFrame {

    public frmPricipal() {
        initComponents();
        this.setSize(1310, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/fondoP.jpg"));
        Image image =icon.getImage();
        desktopPane = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){ g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        menuNuevoD = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuNuevoE = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setBorder(null);
        menuBar.setForeground(new java.awt.Color(0, 0, 0));
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuBar.setPreferredSize(new java.awt.Dimension(85, 50));

        fileMenu.setBackground(new java.awt.Color(255, 255, 255));
        fileMenu.setForeground(new java.awt.Color(0, 0, 0));
        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/setting.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Perfil");
        fileMenu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        fileMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fileMenu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        helpMenu.setForeground(new java.awt.Color(0, 0, 0));
        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/teacher.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Docente");
        helpMenu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menuNuevoD.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        menuNuevoD.setForeground(new java.awt.Color(0, 0, 0));
        menuNuevoD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/newPerson.png"))); // NOI18N
        menuNuevoD.setText("Nuevo Docente");
        menuNuevoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoDActionPerformed(evt);
            }
        });
        helpMenu.add(menuNuevoD);

        fileMenu.add(helpMenu);

        jMenuItem3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/newPerson.png"))); // NOI18N
        jMenuItem3.setText("Nuevo Curso");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem3);

        menuNuevoE.setForeground(new java.awt.Color(0, 0, 0));
        menuNuevoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/student.png"))); // NOI18N
        menuNuevoE.setText("Estudiante");
        menuNuevoE.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/newPerson.png"))); // NOI18N
        jMenuItem1.setText("Nuevo Estudiante");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuNuevoE.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/approvedEstudents.png"))); // NOI18N
        jMenuItem2.setText("Estudiantes Aprobados");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuNuevoE.add(jMenuItem2);

        fileMenu.add(menuNuevoE);

        jMenuItem4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/notes.png"))); // NOI18N
        jMenuItem4.setText("Ingresar Notas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem4);

        exitMenuItem.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        exitMenuItem.setForeground(new java.awt.Color(0, 0, 0));
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuIcons/exit.png"))); // NOI18N
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void menuNuevoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoDActionPerformed
        cargarFurmulario(new registroDoce(), "Registro Docente");

    }//GEN-LAST:event_menuNuevoDActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        cargarFurmulario(new frmRegistroEstudiante(), "Registro Estudiante");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        cargarFurmulario(new frmEstudiantesAprovados(), "Estudiantes Aprobados");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        frmCurso ft = new frmCurso();
        ft.setSize(526, 315);
        cargarFurmulario(ft, "Nuevo Curso");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        cargarFurmulario(new frmNota(), "Ingresar Notas");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void cargarFurmulario(JInternalFrame panel, String nombre) {

        panel.setTitle(nombre);
        //panel.setSize(1110, 600);
        int ancho = ((desktopPane.getWidth() / 2) - panel.getWidth() / 2);
        int alto = ((desktopPane.getHeight() / 2) - panel.getHeight() / 2);
        panel.setLocation(ancho, alto);

        panel.setClosable(true);
        desktopPane.add(panel);
        panel.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPricipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuNuevoD;
    private javax.swing.JMenu menuNuevoE;
    // End of variables declaration//GEN-END:variables

}
