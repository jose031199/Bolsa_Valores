/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_Bolsa;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author luisk
 */
public class horario extends javax.swing.JFrame {
int id;
String tipo_horario;
Consultas_BD base;
    /**
     * Creates new form horario
     */
    public horario() {
        initComponents();
         this.setTitle("Horario");
        this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600,290);
        
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

        jLabel1 = new javax.swing.JLabel();
        txt_id_horario = new javax.swing.JTextField();
        txt_horario = new javax.swing.JTextField();
        btn_ingresar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        label_principal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese Horario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 30));

        txt_id_horario.setBackground(new java.awt.Color(102, 102, 255));
        txt_id_horario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_id_horario.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_horario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_id_horarioFocusLost(evt);
            }
        });
        getContentPane().add(txt_id_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, 60));

        txt_horario.setBackground(new java.awt.Color(102, 102, 255));
        txt_horario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_horario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 190, 60));

        btn_ingresar.setBackground(new java.awt.Color(153, 153, 255));
        btn_ingresar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 100, 40));

        btn_modificar.setBackground(new java.awt.Color(153, 153, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_modificar.setText("Actualizar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 120, 40));

        btn_eliminar.setBackground(new java.awt.Color(153, 153, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 100, 40));

        label_principal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_principal.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(label_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        id = Integer.parseInt(txt_id_horario.getText().trim());
        tipo_horario = txt_horario.getText().trim().toLowerCase();
        base = new Consultas_BD("horario",id,tipo_horario);

        if(!tipo_horario.equals("") && txt_id_horario.getText()!=""){
            if(base.EncontrarRepeteciones("id_horario","tipo_horario")==true){
                  JOptionPane.showMessageDialog(null, "Ya hay un horario con ese id o horario");
                this.Vaciar();
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
        tipo_horario = txt_horario.getText().trim().toLowerCase();//Metodo para ingresar nacionalidad
        id = Integer.parseInt(txt_id_horario.getText());
        base = new Consultas_BD("horario",id,tipo_horario);
        if(!tipo_horario.equals("") && txt_id_horario.getText()!=""){
            base.Modificar("tipo_horario","id_horario");
            this.Vaciar();
        }else{
            JOptionPane.showMessageDialog(null,"No debe de estar vacio");
            this.CampoRojo();
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        tipo_horario = txt_horario.getText().trim().toLowerCase();//Metodo para ingresar nacionalidad
        id = Integer.parseInt(txt_id_horario.getText());
        base = new Consultas_BD("horario",id,tipo_horario);
        if(!tipo_horario.equals("") && txt_id_horario.getText()!=""){
            base.Eliminar("id_horario");
            this.Vaciar();

        }else{
            JOptionPane.showMessageDialog(null,"No debe de estar vacio");
            this.CampoRojo();
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_id_horarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_id_horarioFocusLost
        try{
                id = Integer.parseInt(txt_id_horario.getText());
             
             if(txt_id_horario.getText().isEmpty()){
                txt_horario.setText("");
             }else{
                base = new Consultas_BD("horario",id,tipo_horario);
                txt_horario.setText(base.Buscar("id_horario"));
             }
        }catch(NumberFormatException ex){
            
        }    
    }//GEN-LAST:event_txt_id_horarioFocusLost
  private void CampoVerde(){
        txt_id_horario.setBackground(Color.green);
        txt_horario.setBackground(Color.green);
    }
    
    private void CampoRojo(){
        txt_id_horario.setBackground(Color.red);
        txt_horario.setBackground(Color.red);
    }
    private void Vaciar(){
        txt_id_horario.setText("");
        txt_horario.setText("");
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
            java.util.logging.Logger.getLogger(horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new horario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_principal;
    private javax.swing.JTextField txt_horario;
    private javax.swing.JTextField txt_id_horario;
    // End of variables declaration//GEN-END:variables
}
