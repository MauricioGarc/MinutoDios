/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package seman8;

import java.sql.Connection;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import javax.swing.SwingUtilities;
/**
 *
 * @author andre
 */
public class ProUpdate extends javax.swing.JPanel {

    /**
     * Creates new form ProUpdate
     */
    public ProUpdate() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        Cantidad = new javax.swing.JTextField();
        Estado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Butt_crear = new javax.swing.JButton();
        Butt_crear2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Precio = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Código producto: ");

        jLabel4.setText("Nombre: ");

        jLabel5.setText("Cantidad:");

        jLabel3.setText("Precio de Venta: ");

        jLabel6.setText("Descripción: ");

        jTextField1.setToolTipText("");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        Nombre.setToolTipText("");

        Cantidad.setToolTipText("");

        Estado.setToolTipText("");
        Estado.setEnabled(false);

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        Descripcion.setAutoscrolls(false);
        jScrollPane1.setViewportView(Descripcion);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido al Modulo para actualizar productos");
        jLabel1.setToolTipText("");
        jLabel1.setOpaque(true);

        Butt_crear.setText("Actualizar");
        Butt_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Butt_crearActionPerformed(evt);
            }
        });

        Butt_crear2.setText("Volver");
        Butt_crear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Butt_crear2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Estado:");

        Precio.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jTextField1)
                            .addComponent(Nombre)
                            .addComponent(Cantidad)
                            .addComponent(Precio)
                            .addComponent(Estado)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Butt_crear2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Butt_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Butt_crear2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Butt_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Butt_crear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Butt_crear2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_Butt_crear2ActionPerformed

    private void Butt_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Butt_crearActionPerformed
        Connection conectarp= (java.sql.Connection) BaseDatos.getIntancia().getConexion(); 
        if(conectarp!=null){
            String sql = "UPDATE Productos "
                    + "SET nombre = ?, "
                    + "descripcion = ?, "
                    + "cantidad_en_inventario = ?, "
                    + "precio_venta = ? "
                    + "WHERE codigo_producto = ?";

            try (PreparedStatement stmt = conectarp.prepareStatement(sql)) {
                stmt.setString(1, Nombre.getText());
                stmt.setString(2, Descripcion.getText());
                stmt.setInt(3, Integer.parseInt(Cantidad.getText()));
                stmt.setDouble(4, Double.parseDouble(Precio.getText()));
                stmt.setString(5, jTextField1.getText());

                int filasActualizadas = stmt.executeUpdate();

                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(null, "Actualizacion realizada correctamente.", "", JOptionPane.INFORMATION_MESSAGE );
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el producto con el código especificado.", "", JOptionPane.ERROR_MESSAGE );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Error: al intentar conectar con la base de datos", "", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_Butt_crearActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        String sql = "SELECT * FROM Productos WHERE codigo_producto = ?";
        Connection conectarp= (java.sql.Connection) BaseDatos.getIntancia().getConexion(); 
        try(PreparedStatement stmt = conectarp.prepareStatement(sql)) {
            stmt.setString(1, jTextField1.getText());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Nombre.setText(rs.getString("nombre"));
                Descripcion.setText(rs.getString("descripcion"));
                Cantidad.setText(rs.getInt("cantidad_en_inventario")+"");
                Precio.setText(rs.getDouble("precio_venta")+"");
                if(rs.getInt("productoActivo")==1){
                    Estado.setText("Prodcuto Activo");
                    jTextField1.setEnabled(false);
                    Nombre.setEnabled(true);
                    Descripcion.setEnabled(true);
                    Cantidad.setEnabled(true);
                    Precio.setEnabled(true);
                }
                else{
                    jTextField1.setEnabled(true);
                    Nombre.setEnabled(false);
                    Descripcion.setEnabled(false);
                    Cantidad.setEnabled(false);
                    Precio.setEnabled(false);
                    Estado.setText("Prodcuto Borrado");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Producto no encontrado.", "", JOptionPane.ERROR_MESSAGE );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextField1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Butt_crear;
    private javax.swing.JButton Butt_crear2;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JTextField Estado;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Precio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
