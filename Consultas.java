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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisk
 */
public class Consultas extends javax.swing.JFrame {
DefaultTableModel model=new DefaultTableModel();
 String query="";
    /**
     * Creates new form Consultas
     */
    public Consultas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Generar Consultas");
        this.setResizable(false);
        this.setSize(680,390);
        
        ImageIcon wallpaper=new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono=new ImageIcon(wallpaper.getImage().getScaledInstance(label_principal.getWidth(),
                label_principal.getHeight(),Image.SCALE_DEFAULT));
        label_principal.setIcon(icono);
        
        cmb_orden_empleado.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_intro4 = new javax.swing.JLabel();
        cmb_mantenimiento = new javax.swing.JComboBox<>();
        cmb_orden_bolsa = new javax.swing.JComboBox<>();
        cmb_orden_empleado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_consultas = new javax.swing.JTable();
        btn_mostrar = new javax.swing.JButton();
        label_principal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_intro4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel_intro4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_intro4.setText("CONSULTAS");
        getContentPane().add(jLabel_intro4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 30));

        cmb_mantenimiento.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cmb_mantenimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolsa", "Empleado" }));
        cmb_mantenimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_mantenimientoItemStateChanged(evt);
            }
        });
        cmb_mantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_mantenimientoActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_mantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        cmb_orden_bolsa.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cmb_orden_bolsa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexo", "Nacionalidad", "Perfil" }));
        getContentPane().add(cmb_orden_bolsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        cmb_orden_empleado.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cmb_orden_empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Departamento", "Puesto", "Tipo_Horario", " " }));
        getContentPane().add(cmb_orden_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        tabla_consultas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_consultas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 640, 210));

        btn_mostrar.setBackground(new java.awt.Color(153, 153, 255));
        btn_mostrar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_mostrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_mostrar.setText("Mostrar");
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, -1));
        getContentPane().add(label_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_mantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_mantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_mantenimientoActionPerformed

    private void cmb_mantenimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_mantenimientoItemStateChanged
        if(cmb_mantenimiento.getSelectedItem().equals("Bolsa")){
            cmb_orden_bolsa.setEnabled(true);
            cmb_orden_empleado.setEnabled(false);
        }else{
               cmb_orden_bolsa.setEnabled(false);
            cmb_orden_empleado.setEnabled(true);
        }
    }//GEN-LAST:event_cmb_mantenimientoItemStateChanged

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
       String seleccion = cmb_mantenimiento.getSelectedItem().toString();
       if(seleccion.equals("Bolsa")){
           String seleccion2 = cmb_orden_bolsa.getSelectedItem().toString();
          
           
           model.setRowCount(0); 
           model.setColumnCount(0);
           try{
               Connection cn = Conexion.conectar();
               if(seleccion2.equalsIgnoreCase("Sexo")){
                   query="Select nombre,apellido_p,apellido_m,sexo from bolsa order by sexo,nombre";
               }
               if(seleccion2.equalsIgnoreCase("Nacionalidad")){
                    query="Select nombre,apellido_p,apellido_m,nacion from bolsa,nacionalidad where bolsa.id_nac=nacionalidad.id_nac order by nacion,nombre";
               }
               if(seleccion2.equalsIgnoreCase("Perfil")){
                   query="Select nombre,apellido_p,apellido_m,perfil from bolsa,perfil where bolsa.id_perfil=perfil.id_perfil order by perfil,nombre";
               }
               PreparedStatement pst = cn.prepareStatement(query);
               ResultSet rs = pst.executeQuery();
               
               tabla_consultas = new JTable(model);
               jScrollPane1.setViewportView(tabla_consultas);
               
               model.addColumn("Nombre");
               model.addColumn("Apellido P");
               model.addColumn("Apellido M");
               model.addColumn(seleccion2);
               
               while(rs.next()){
                   Object fila[]= new Object[4];
                   for(int i=0;i<4;i++){
                       fila[i]= rs.getObject(i+1);
                   }
                   model.addRow(fila);
                   
               }
               cn.close();   
           }catch(SQLException ex){
              System.err.println("Error al recuperar de los registros. "+ex);
           }
       }else{
           String seleccion3 = cmb_orden_empleado.getSelectedItem().toString();
          
           
           model.setRowCount(0); //Limpiar
           model.setColumnCount(0);
           try{
               Connection cn2 = Conexion.conectar();
               if(seleccion3.equalsIgnoreCase("Departamento")){
                   query="Select nombre,apellido_p,apellido_m,tipo_depto from bolsa,empleado,departamento where id_empleado=id_bolsa and empleado.id_depto=departamento.id_depto order by tipo_depto,nombre";
               }
               if(seleccion3.equalsIgnoreCase("Puesto")){
                    query="Select nombre,apellido_p,apellido_m,tipo_puesto from bolsa,empleado,puesto where id_empleado=id_bolsa and empleado.id_puesto=puesto.id_puesto order by tipo_puesto,nombre";
               }
               if(seleccion3.equalsIgnoreCase("Tipo_Horario")){
                   query="Select nombre,apellido_p,apellido_m,tipo_horario from bolsa,empleado,horario where id_empleado=id_bolsa and empleado.id_horario=horario.id_horario order by tipo_horario,nombre";
               }
               PreparedStatement pst = cn2.prepareStatement(query);
               ResultSet rs = pst.executeQuery();
               
               tabla_consultas = new JTable(model);
               jScrollPane1.setViewportView(tabla_consultas);
               
               model.addColumn("Nombre");
               model.addColumn("Apellido P");
               model.addColumn("Apellido M");
               model.addColumn(seleccion3);
               
               while(rs.next()){
                   Object fila[]= new Object[4];
                   for(int i=0;i<4;i++){
                       fila[i]= rs.getObject(i+1);
                   }
                   model.addRow(fila);
                   
               }
               cn2.close();   
           }catch(SQLException ex){
              System.err.println("Error al recuperar de los registros. "+ex);
           }
           
       }
    }//GEN-LAST:event_btn_mostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mostrar;
    private javax.swing.JComboBox<String> cmb_mantenimiento;
    private javax.swing.JComboBox<String> cmb_orden_bolsa;
    private javax.swing.JComboBox<String> cmb_orden_empleado;
    private javax.swing.JLabel jLabel_intro4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_principal;
    private javax.swing.JTable tabla_consultas;
    // End of variables declaration//GEN-END:variables
}