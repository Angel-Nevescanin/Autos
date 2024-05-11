/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.autos.ui;

import mx.itson.autos.ui.FrameCliente;

/**
 *
 * @author angel
 */
public class MainAutos extends javax.swing.JFrame {

    /**
     * Creates new form MainCinepolis
     */
    public MainAutos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPeliculasFrame = new javax.swing.JButton();
        btnEmpleadosFrame = new javax.swing.JButton();
        btnFrameClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPeliculasFrame.setText("AUTOS");
        btnPeliculasFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPeliculasFrameMouseClicked(evt);
            }
        });
        getContentPane().add(btnPeliculasFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        btnEmpleadosFrame.setText("ADMINISTRADOR");
        btnEmpleadosFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpleadosFrameMouseClicked(evt);
            }
        });
        btnEmpleadosFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosFrameActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmpleadosFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        btnFrameClientes.setText("CLIENTES");
        btnFrameClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFrameClientesMouseClicked(evt);
            }
        });
        getContentPane().add(btnFrameClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Frame Principal para poder interacturar entre los diferentes frames de edicion
    private void btnFrameClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFrameClientesMouseClicked
        FrameCliente abrir= new FrameCliente();
        abrir.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnFrameClientesMouseClicked

    private void btnEmpleadosFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosFrameMouseClicked
        FrameAdministrador abrir= new FrameAdministrador();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEmpleadosFrameMouseClicked

    private void btnPeliculasFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPeliculasFrameMouseClicked
        FrameAutos abrir= new FrameAutos();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPeliculasFrameMouseClicked

    private void btnEmpleadosFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmpleadosFrameActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmpleadosFrame;
    private javax.swing.JButton btnFrameClientes;
    private javax.swing.JButton btnPeliculasFrame;
    // End of variables declaration//GEN-END:variables
}
