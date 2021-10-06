/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_Bolsa;

import clases.Conexion;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisk
 */
public class Muerto extends javax.swing.JFrame {
 DefaultTableModel model=new DefaultTableModel();
    /**
     * Creates new form Muerto
     */
    public Muerto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Muertos");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(790, 460);
        
        ImageIcon wallpaper=new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono=new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Principal.getWidth(),
                jLabel_Principal.getHeight(),Image.SCALE_DEFAULT));
        jLabel_Principal.setIcon(icono);
        
        this.repaint();
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("Select id_muerto,nombre,apellido_p,apellido_m,id_bolsa,razon from muerto");
            ResultSet rs = pst.executeQuery();
             jTable_Muertos =new JTable(model);
            jScrollPane1.setViewportView(jTable_Muertos);
            
            
             model.addColumn("Id_Muerto");
            model.addColumn("Nombre");
            model.addColumn("Apellido_P");
            model.addColumn("Apellido_M");
            model.addColumn("Id_Bolsa");
            model.addColumn("Razon");
            
            
            while(rs.next()){
                Object[] fila = new Object[6];
                for(int i=0;i<6;i++){
                     
                     fila[i]=rs.getObject(i+1);
                      
                }
                model.addRow(fila);
            }
            cn.close();
        }catch(SQLException ex){
            
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Muertos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Principal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Muertos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTable_Muertos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_Muertos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 720, 300));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MUERTOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 140, -1));
        getContentPane().add(jLabel_Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Mantenimiento_bolsa().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Muerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Muerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Muerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Muerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Muerto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Principal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Muertos;
    // End of variables declaration//GEN-END:variables
}
