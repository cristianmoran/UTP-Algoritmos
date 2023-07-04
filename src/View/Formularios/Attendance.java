/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Formularios;

import Model.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Attendance extends javax.swing.JPanel {

    private void cargarDatosAsistencia() {
        // Crear una instancia de DBConnection
        DBConnection dbConnection = new DBConnection();

        try {
            // Abrir la conexión a la base de datos
            dbConnection.openConnection();

            // Consulta SQL para obtener los datos de asistencia
            String query = "SELECT Id, cedula, Nombre, Apellido, Cargo, Hora_entrada, Hora_salida, Turno FROM asistencia";

            // Preparar la declaración SQL
            PreparedStatement statement = dbConnection.prepareStatement(query);

            // Ejecutar la consulta y obtener los resultados
            ResultSet resultSet = statement.executeQuery();

            // Limpiar los datos existentes en la tabla
            DefaultTableModel model = (DefaultTableModel) datos_asis.getModel();
            model.setRowCount(0);

            // Recorrer los resultados y agregarlos a la tabla
            while (resultSet.next()) {
                String Id = resultSet.getString("Id");
                String cedula = resultSet.getString("cedula");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                String cargo = resultSet.getString("Cargo");
                String horaEntrada = resultSet.getString("Hora_entrada");
                String horaSalida = resultSet.getString("Hora_salida");
                String turno = resultSet.getString("Turno");

                // Agregar una nueva fila a la tabla con los datos
                model.addRow(new Object[]{Id, cedula, nombre, apellido, cargo, horaEntrada, horaSalida, turno});
            }

            // Cerrar el ResultSet, el PreparedStatement y la conexión a la base de datos
            resultSet.close();
            statement.close();
            dbConnection.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos de asistencia: " + e.getMessage());
        }

    }

    public Attendance() {
        initComponents();

        // Llamar al método para cargar los datos de asistencia en la tabla
        cargarDatosAsistencia();
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcargo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtentrada = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtsalida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_turno = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        datos_asis = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel1.setBackground(new java.awt.Color(246, 247, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(895, 544));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Datos del empleado");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Id:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Cédula:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Apellido:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Cargo:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setText("Jornada laboral");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Hora entrada:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Hora salida:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Turno:");

        datos_asis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "cedula", "Nombre", "Apellido", "Cargo", "Hora_entrada", "Hora_salida", "Turno"
            }
        ));
        jScrollPane4.setViewportView(datos_asis);
        if (datos_asis.getColumnModel().getColumnCount() > 0) {
            datos_asis.getColumnModel().getColumn(0).setMinWidth(50);
            datos_asis.getColumnModel().getColumn(0).setPreferredWidth(50);
            datos_asis.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtcedula))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtId))
                                    .addComponent(jLabel1))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(jLabel6))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtentrada)
                                    .addComponent(txt_turno, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(529, 529, 529)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnmodificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 113, Short.MAX_VALUE)))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actionAdd() {
        String id = txtId.getText();
        String cedula = txtcedula.getText();
        String nombre = txtnombre.getText();
        String apellido = txtapellido.getText();
        String cargo = txtcargo.getText();
        String horaEntrada = txtentrada.getText();
        String horaSalida = txtsalida.getText();
        String turno = txt_turno.getText();

        // Validar que los campos no estén vacíos
        if (id.isEmpty() || cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                || cargo.isEmpty() || horaEntrada.isEmpty() || horaSalida.isEmpty() || turno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insertar datos en la base de datos
        try {
            DBConnection db = new DBConnection();
            db.openConnection();

            String query = "INSERT INTO asistencia (id, cedula, nombre, apellido, cargo, hora_entrada, hora_salida, turno) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = db.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, cedula);
            statement.setString(3, nombre);
            statement.setString(4, apellido);
            statement.setString(5, cargo);
            statement.setString(6, horaEntrada);
            statement.setString(7, horaSalida);
            statement.setString(8, turno);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Datos agregados correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarDatosAsistencia();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }

            db.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
// Declarar una variable global para almacenar el ID del registro que se va a editar
    private int idEditar = -1;
    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        actionAdd();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        actionUpdate();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        actionDelete();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        actionModify();
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void actionModify() {
        // Obtener el ID del registro seleccionado en la tabla (puedes hacer esto desde un evento de selección de la tabla)
        int filaSeleccionada = datos_asis.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener el valor del ID en la columna 0 (o la columna donde esté el ID en tu tabla)
            idEditar = Integer.parseInt(datos_asis.getValueAt(filaSeleccionada, 0).toString());

            // Obtener los datos del registro desde la base de datos usando el ID
            try {
                DBConnection db = new DBConnection();
                db.openConnection();

                String query = "SELECT * FROM asistencia WHERE id=?";
                PreparedStatement statement = db.prepareStatement(query);
                statement.setInt(1, idEditar);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    // Mostrar los datos en los campos de texto para que puedan ser editados
                    txtId.setText(rs.getString("id"));
                    txtcedula.setText(rs.getString("cedula"));
                    txtnombre.setText(rs.getString("nombre"));
                    txtapellido.setText(rs.getString("apellido"));
                    txtcargo.setText(rs.getString("cargo"));
                    txtentrada.setText(rs.getString("hora_entrada"));
                    txtsalida.setText(rs.getString("hora_salida"));
                    txt_turno.setText(rs.getString("turno"));
                }

                db.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al obtener los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro para editar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actionUpdate() {
        // Verificar que se haya seleccionado un registro para editar
        if (idEditar != -1) {
            String id = txtId.getText();
            String cedula = txtcedula.getText();
            String nombre = txtnombre.getText();
            String apellido = txtapellido.getText();
            String cargo = txtcargo.getText();
            String horaEntrada = txtentrada.getText();
            String horaSalida = txtsalida.getText();
            String turno = txt_turno.getText();

            // Validar que los campos no estén vacíos
            if (id.isEmpty() || cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                    || cargo.isEmpty() || horaEntrada.isEmpty() || horaSalida.isEmpty() || turno.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar los datos en la base de datos
            try {
                DBConnection db = new DBConnection();
                db.openConnection();

                String query = "UPDATE asistencia SET id=?, cedula=?, nombre=?, apellido=?, cargo=?, hora_entrada=?, hora_salida=?, turno=? WHERE id=?";
                PreparedStatement statement = db.prepareStatement(query);
                statement.setString(1, id);
                statement.setString(2, cedula);
                statement.setString(3, nombre);
                statement.setString(4, apellido);
                statement.setString(5, cargo);
                statement.setString(6, horaEntrada);
                statement.setString(7, horaSalida);
                statement.setString(8, turno);
                statement.setInt(9, idEditar);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Datos actualizados correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarDatosAsistencia();
                    // Limpiar los campos de texto y restablecer el ID de edición
                    limpiarCampos();
                    idEditar = -1;
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }

                db.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro para editar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtcedula.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtcargo.setText("");
        txtentrada.setText("");
        txtsalida.setText("");
        txt_turno.setText("");
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void actionDelete() {
        // Obtener el ID del registro seleccionado en la tabla (puedes hacer esto desde un evento de selección de la tabla)
        int filaSeleccionada = datos_asis.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener el valor del ID en la columna 0 (o la columna donde esté el ID en tu tabla)
            int idEliminar = Integer.parseInt(datos_asis.getValueAt(filaSeleccionada, 0).toString());

            // Mostrar un mensaje de confirmación antes de eliminar el registro
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Eliminar el registro de la base de datos
                try {
                    DBConnection db = new DBConnection();
                    db.openConnection();

                    String query = "DELETE FROM asistencia WHERE id=?";
                    PreparedStatement statement = db.prepareStatement(query);
                    statement.setInt(1, idEliminar);

                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "Registro eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        cargarDatosAsistencia();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    db.closeConnection();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JTable datos_asis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txt_turno;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcargo;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtentrada;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsalida;
    // End of variables declaration//GEN-END:variables
}
