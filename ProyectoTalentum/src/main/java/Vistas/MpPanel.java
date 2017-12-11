package Vistas;

import ProyectoTalentum.ProyectoTalentum.MapImgEnJpanel;

public class MpPanel extends javax.swing.JFrame {
    
    public MpPanel() {
        initComponents();
        this.setLocationRelativeTo(null); // Centrar pantalla 
    }
                            
    private void initComponents() {} // Codigo generado automaticamente.                        

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {
    	MapImgEnJpanel im = new MapImgEnJpanel(jPanel1);
        jPanel1.add(im).repaint();
    }                                              

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MpPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   

}