/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Proyecto_Bolsa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author luisk
 */
public class Experiencia extends javax.swing.JFrame {
 public int id;
 public String experiencia;
 Consultas_BD base;
    /** Creates new form Experiencia */
    public Experiencia() {
        initComponents();
        this.setTitle("Experiencia");
        this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(580,310);
        
         ImageIcon wallpaper=new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono=new ImageIcon(wallpaper.getImage().getScaledInstance(label_principal.getWidth(),
                label_principal.getHeight(),Image.SCALE_DEFAULT));
        label_principal.setIcon(icono);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_experiencia = new javax.swing.JTextArea();
        txt_id_experiencia = new javax.swing.JTextField();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        label_principal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese Experiencia");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 30));

        btn_ingresar.setBackground(new java.awt.Color(153, 153, 255));
        btn_ingresar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 100, 40));

        txt_experiencia.setBackground(new java.awt.Color(102, 102, 255));
        txt_experiencia.setColumns(20);
        txt_experiencia.setForeground(new java.awt.Color(255, 255, 255));
        txt_experiencia.setRows(5);
        jScrollPane1.setViewportView(txt_experiencia);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 180, 100));

        txt_id_experiencia.setBackground(new java.awt.Color(102, 102, 255));
        txt_id_experiencia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_id_experiencia.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_experiencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_id_experienciaFocusLost(evt);
            }
        });
        getContentPane().add(txt_id_experiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 60));

        btn_modificar.setBackground(new java.awt.Color(153, 153, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_modificar.setText("Actualizar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 120, 40));

        btn_eliminar.setBackground(new java.awt.Color(153, 153, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 100, 40));

        label_principal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_principal.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(label_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
         id = Integer.parseInt(txt_id_experiencia.getText().trim());
         experiencia = txt_experiencia.getText().trim().toLowerCase();
         base = new Consultas_BD("experiencia",id,experiencia);
        if(!experiencia.equals("") && txt_id_experiencia.getText()!=""){
            if(base.EncontrarRepeteciones("id_exp","experiencia")==true){
                  JOptionPane.showMessageDialog(null, "Ya hay una experiencia con ese id o experiencia");
                 this.Vaciar();
            }else{
                base.Insertar();
                
                JOptionPane.showMessageDialog(null,"Insercion Lograda");
               this.Vaciar();
               this.CampoVerde();
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"No debe de estar vacio");
            txt_experiencia.setBackground(Color.red);
        }
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        experiencia = txt_experiencia.getText().trim().toLowerCase();//Metodo para ingresar nacionalidad
        id = Integer.parseInt(txt_id_experiencia.getText());

        if(!experiencia.equals("") && txt_id_experiencia.getText()!=""){
           base = new Consultas_BD("experiencia",id,experiencia);
           
           base.Modificar("id_exp", "experiencia");
            this.Vaciar();
            
        }else{
            JOptionPane.showMessageDialog(null,"No debe de estar vacio");
            this.CampoRojo();
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        experiencia = txt_experiencia.getText().trim().toLowerCase();//Metodo para ingresar nacionalidad
        id = Integer.parseInt(txt_id_experiencia.getText());

        if(!experiencia.equals("") && txt_id_experiencia.getText()!=""){
        base = new Consultas_BD("experiencia",id,experiencia);
            base.Eliminar("id_exp");
            this.Vaciar();
        }else{
            JOptionPane.showMessageDialog(null,"No debe de estar vacio");
            this.CampoRojo();
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_id_experienciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_id_experienciaFocusLost
         try{
                id = Integer.parseInt(txt_id_experiencia.getText());
             
             if(txt_id_experiencia.getText().isEmpty()){
                txt_experiencia.setText("");
             }else{
                base = new Consultas_BD("experiencia",id,experiencia);
                txt_experiencia.setText(base.Buscar("id_exp"));
             }
        }catch(NumberFormatException ex){
            
        }    
    }//GEN-LAST:event_txt_id_experienciaFocusLost

    private void Vaciar(){
        txt_id_experiencia.setText("");
        txt_experiencia.setText("");
    }
    private void CampoVerde(){
        txt_id_experiencia.setBackground(Color.green);
        txt_experiencia.setBackground(Color.green);
    }
    private void CampoRojo(){
        txt_id_experiencia.setBackground(Color.red);
        txt_experiencia.setBackground(Color.red);
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
            java.util.logging.Logger.getLogger(Experiencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Experiencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Experiencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Experiencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Experiencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_principal;
    private javax.swing.JTextArea txt_experiencia;
    private javax.swing.JTextField txt_id_experiencia;
    // End of variables declaration//GEN-END:variables

}
