/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_Bolsa;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author luisk
 */
public class Escolaridad extends javax.swing.JFrame {
 int id;
 String escolaridad;
  public Consultas_BD base;
    /**
     * Creates new form Escolaridad
     */
    public Escolaridad() {
        initComponents();
        this.setTitle("Escolaridad");
        this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600,240);
        
        //base = new Consultas_BD("escolaridad",id,escolaridad);
         ImageIcon wallpaper=new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono=new ImageIcon(wallpaper.getImage().getScaledInstance(label_principal.getWidth(),
                label_principal.getHeight(),Image.SCALE_DEFAULT));
        label_principal.setIcon(icono);
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_escolaridad = new javax.swing.JTextField();
        btn_ingresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_id_esc = new javax.swing.JTextField();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        label_principal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_escolaridad.setBackground(new java.awt.Color(102, 102, 255));
        txt_escolaridad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_escolaridad.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_escolaridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 220, 60));

        btn_ingresar.setBackground(new java.awt.Color(153, 153, 255));
        btn_ingresar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, 40));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese Escolaridad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        txt_id_esc.setBackground(new java.awt.Color(102, 102, 255));
        txt_id_esc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_id_esc.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_esc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_id_escFocusLost(evt);
            }
        });
        getContentPane().add(txt_id_esc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 60));

        btn_modificar.setBackground(new java.awt.Color(153, 153, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_modificar.setText("Actualizar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 120, 40));

        btn_eliminar.setBackground(new java.awt.Color(153, 153, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 100, 40));

        label_principal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_principal.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(label_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
         id = Integer.parseInt(txt_id_esc.getText().trim());
         escolaridad = txt_escolaridad.getText().trim().toLowerCase();
         base = new Consultas_BD("escolaridad",id,escolaridad);
        if(!escolaridad.equals("") && txt_id_esc.getText()!=""){
            
            if(base.EncontrarRepeteciones("id_esc","descripcion")==true){
              JOptionPane.showMessageDialog(null, "Ya hay un escolaridad con ese id o escolaridad");
                txt_escolaridad.setText("");
            }else{
             base.Insertar();
              JOptionPane.showMessageDialog(null,"Insercion Lograda");
              this.Vaciar();
              this.CampoVerde();
              
            }
           
        }else{
            JOptionPane.showMessageDialog(null,"No debe de estar vacio");
            this.CampoRojo();
        }
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        escolaridad = txt_escolaridad.getText().trim().toLowerCase();//Metodo para ingresar nacionalidad
        id = Integer.parseInt(txt_id_esc.getText());
            base = new Consultas_BD("escolaridad",id,escolaridad);
        if(!escolaridad.equals("") && txt_id_esc.getText()!=""){
             base.Modificar("descripcion","id_esc");
             this.Vaciar();
             this.CampoVerde();
      
        }else{
            JOptionPane.showMessageDialog(null,"No debe de estar vacio");
            this.CampoRojo();
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        escolaridad = txt_escolaridad.getText().trim().toLowerCase();//Metodo para ingresar nacionalidad
        id = Integer.parseInt(txt_id_esc.getText());
        base = new Consultas_BD("escolaridad",id,escolaridad);
        
        if(!escolaridad.equals("") && txt_id_esc.getText()!=""){
            base.Eliminar("id_esc");
            this.Vaciar();
           
        }else{
            JOptionPane.showMessageDialog(null,"No debe de estar vacio");
            this.CampoRojo();
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_id_escFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_id_escFocusLost
        try{
                id = Integer.parseInt(txt_id_esc.getText());
             
             if(txt_id_esc.getText().isEmpty()){
                txt_escolaridad.setText("");
             }else{
                base = new Consultas_BD("escolaridad",id,escolaridad);
                txt_escolaridad.setText(base.Buscar("id_esc"));
             }
        }catch(NumberFormatException ex){
            
        }    
    }//GEN-LAST:event_txt_id_escFocusLost
public void Vaciar(){
    txt_id_esc.setText("");
    txt_escolaridad.setText("");
}
public void CampoVerde(){
    txt_id_esc.setBackground(Color.green);
    txt_escolaridad.setBackground(Color.green);
}
public void CampoRojo(){
    if(txt_id_esc.getText()!=""){
        txt_id_esc.setBackground(Color.red);
    }else{
        txt_escolaridad.setBackground(Color.red);
    }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Escolaridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Escolaridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Escolaridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Escolaridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Escolaridad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_principal;
    private javax.swing.JTextField txt_escolaridad;
    private javax.swing.JTextField txt_id_esc;
    // End of variables declaration//GEN-END:variables
}
