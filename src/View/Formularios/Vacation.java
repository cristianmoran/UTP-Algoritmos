package View.Formularios;

import Model.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Vacation extends javax.swing.JPanel {

    DefaultTableModel modelo;

    private void getDataVacacion() {
        // Crear una instancia de DBConnection
        DBConnection dbConnection = new DBConnection();

        try {
            // Abrir la conexión a la base de datos
            dbConnection.openConnection();

            String query = "select Código, Nombre, Autoriza, Fecha_inicio, Fecha_salida FROM vacacion";

            // Preparar la declaración SQL
            PreparedStatement statement = dbConnection.prepareStatement(query);

            // Ejecutar la consulta y obtener los resultados
            ResultSet resultSet = statement.executeQuery();

            // Limpiar los datos existentes en la tabla
            DefaultTableModel model = (DefaultTableModel) tablav.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                String codigo = resultSet.getString("Código");
                String nombre = resultSet.getString("Nombre");
                String autoriza = resultSet.getString("Autoriza");
                String fecha_inicio = resultSet.getString("Fecha_inicio");
                String fecha_salida = resultSet.getString("Fecha_salida");

                model.addRow(new Object[]{codigo, nombre, autoriza, fecha_inicio, fecha_salida});
            }

            // Cerrar el ResultSet, el PreparedStatement y la conexión a la base de datos
            resultSet.close();
            statement.close();
            dbConnection.closeConnection();
        } catch (SQLException e) {
            System.out.println("No se pude cargar el registro" + e.getMessage());
        }
    }

    public Vacation() {
        initComponents();
        getDataVacacion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtFei = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtAuto = new javax.swing.JTextField();
        txtFes = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablav = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(895, 544));

        jPanel1.setBackground(new java.awt.Color(246, 247, 245));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("REGISTRO DE VACACIONES");

        jPanel2.setBackground(new java.awt.Color(246, 247, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Código:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Autoriza:");

        jLabel5.setText("Fecha inicio:");

        jLabel6.setText("Fecha final:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCod, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(txtNom)
                    .addComponent(txtAuto))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFei, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(txtFes))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtFei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18))
        );

        jPanel3.setBackground(new java.awt.Color(246, 247, 245));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla"));

        tablav.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Autoriza", "Fecha inicio", "Fecha salida"
            }
        ));
        jScrollPane1.setViewportView(tablav);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(246, 247, 245));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));

        btnAgregar.setText("NUEVO");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Modificar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    //metodo para agregar registro
    void Agregar() {
        String codigo = txtCod.getText();
        String nombre = txtNom.getText();
        String autoriza = txtAuto.getText();
        String fecha_inicio = txtFei.getText();
        String fecha_salida = txtFes.getText();

        // Validar que los campos no estén vacíos
        if (codigo.equals("") || nombre.equals("") || autoriza.equals("") || fecha_inicio.equals("") || fecha_salida.equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan ingresar datos");
            return;
        }

        try {
            DBConnection db = new DBConnection();
            db.openConnection();

            String sql = "INSERT INTO vacacion (Código, Nombre, Autoriza, Fecha_inicio, Fecha_salida) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = db.prepareStatement(sql);
            statement.setString(1, codigo);
            statement.setString(2, nombre);
            statement.setString(3, autoriza);
            statement.setString(4, fecha_inicio);
            statement.setString(5, fecha_salida);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Registro realizado");
                getDataVacacion();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar los datos");
            }
        } catch (Exception e) {

        }
    }

    //metodo para agregar registro
    private int idEditar = -1;

    void Modificar() {
        int filaSeleccionada = tablav.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener el valor del ID en la columna 0 (o la columna donde esté el ID en tu tabla)
            idEditar = Integer.parseInt(tablav.getValueAt(filaSeleccionada, 0).toString());

            try {
                DBConnection db = new DBConnection();
                db.openConnection();

                String sql = "SELECT * FROM vacacion WHERE Código=?";
                PreparedStatement statement = db.prepareStatement(sql);
                statement.setInt(1, idEditar);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    // Mostrar los datos en los campos de texto para que puedan ser editados
                    txtCod.setText(rs.getString("Código"));
                    txtNom.setText(rs.getString("Nombre"));
                    txtAuto.setText(rs.getString("Autoriza"));
                    txtFei.setText(rs.getString("Fecha_inicio"));
                    txtFes.setText(rs.getString("Fecha_salida"));
                }

                db.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener los datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }
    }

    //metodo para actualizar registro
    void Actualizar() {

        if (idEditar != -1) {
            String codigo = txtCod.getText();
            String nombre = txtNom.getText();
            String autoriza = txtAuto.getText();
            String fecha_inicio = txtFei.getText();
            String fecha_salida = txtFes.getText();

            // Validar que los campos no estén vacíos
            if (codigo.equals("") || nombre.equals("") || autoriza.equals("") || fecha_inicio.equals("") || fecha_salida.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan ingresar datos");
                return;
            }

            // Actualizar los datos en la base de datos
            try {
                DBConnection db = new DBConnection();
                db.openConnection();

                String sql = "UPDATE vacacion SET Código=?, Nombre=?, Autoriza=?, Fecha_inicio=?, Fecha_salida=? WHERE Código=?";

                PreparedStatement statement = db.prepareStatement(sql);
                statement.setString(1, codigo);
                statement.setString(2, nombre);
                statement.setString(3, autoriza);
                statement.setString(4, fecha_inicio);
                statement.setString(5, fecha_salida);
                statement.setInt(6, idEditar);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Actualizado");
                    getDataVacacion();
                    // Limpiar los campos de texto y restablecer el ID de edición
                    limpiarCampos();
                    idEditar = -1;
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar");
                }

                db.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error de base de datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a editar");
        }
    }

    private void limpiarCampos() {
        txtCod.setText("");
        txtNom.setText("");
        txtAuto.setText("");
        txtFei.setText("");
        txtFes.setText("");
    }

    void Eliminar() {

        int filaSeleccionada = tablav.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener el valor del ID en la columna 0 (o la columna donde esté el ID en tu tabla)
            int idEliminar = Integer.parseInt(tablav.getValueAt(filaSeleccionada, 0).toString());

            // Mostrar un mensaje de confirmación antes de eliminar el registro
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Eliminación  del registro de la base de datos
                try {
                    DBConnection db = new DBConnection();
                    db.openConnection();

                    String query = "DELETE FROM vacacion WHERE Código=?";
                    PreparedStatement statement = db.prepareStatement(query);
                    statement.setInt(1, idEliminar);

                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "Registro eliminado");
                        // Actualizar la tabla u otros componentes después de la eliminación
                        getDataVacacion();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar registro");
                    }

                    db.closeConnection();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en la bsae de datos");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar registro a eliminar");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablav;
    private javax.swing.JTextField txtAuto;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtFei;
    private javax.swing.JTextField txtFes;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
