
package administrador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import reportes.exportar_excel;


public class registro_music extends javax.swing.JFrame {

    public static final String url = "jdbc:mysql://localhost:3306/biblioteca_music";
    public static final String user = "root";
    public static final String password = "";
    TableRowSorter trs = null;

    DefaultTableModel modelo;

    public registro_music() {
        initComponents();
        this.setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Titulo");
        modelo.addColumn("Artista");
        modelo.addColumn("Genero");

        mostrarDatos();
    }

    public void mostrarDatos() {

        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = DriverManager.getConnection(url, user, password);

            String sql = "select id, titulo, artista, genero from artistas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            modelo.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String artista = rs.getString("artista");
                String genero = rs.getString("genero");

                modelo.addRow(new Object[]{id, titulo, artista, genero});

            }

            jtDatos.setModel(modelo);
            rs.close();
            ps.close();
            conexion.close();

        } catch (Exception ex) {
            System.out.println("error al conectar a la base datos " + ex.getMessage());

        }

    }

    public Connection getConnection() {
        Connection conexion = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa....");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion...." + e);
        }
        return conexion;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_actualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jlId = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtTitulo = new javax.swing.JTextField();
        jtArtista = new javax.swing.JTextField();
        jtGenero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jlTitulo = new javax.swing.JLabel();
        jlArtista = new javax.swing.JLabel();
        jlGenero = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        campo_buscar = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        btn_exportar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        btn_actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-actualizar (1).png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jlId.setForeground(new java.awt.Color(255, 255, 255));
        jlId.setText("Id:");

        jtId.setEnabled(false);
        jtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtIdActionPerformed(evt);
            }
        });

        jtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTituloActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N

        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Titulo: ");

        jlArtista.setForeground(new java.awt.Color(255, 255, 255));
        jlArtista.setText("Artista:");

        jlGenero.setForeground(new java.awt.Color(255, 255, 255));
        jlGenero.setText("Genero:");

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("BIBLIOTECA MUSIC");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(titulo)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlArtista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 62, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlTitulo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlGenero)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(71, 71, 71)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlId)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTitulo)
                    .addComponent(jtArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlArtista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlGenero))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jtDatos.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Artista", "Genero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtDatos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("REGISTRO DE DATOS");

        campo_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_buscarActionPerformed(evt);
            }
        });
        campo_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_buscarKeyTyped(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(255, 0, 0));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_exportar.setBackground(new java.awt.Color(255, 255, 102));
        btn_exportar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sobresalir123.png"))); // NOI18N
        btn_exportar.setText("Exportar ");
        btn_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_exportar))
                    .addComponent(campo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_buscarActionPerformed

    }//GEN-LAST:event_campo_buscarActionPerformed

    private void campo_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_buscarKeyTyped
        campo_buscar.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent ke) {
        // Cuando se libera una tecla en el campo de búsqueda, se dispara este evento

        // Se crea un filtro de filas para el TableRowSorter basado en el texto ingresado en el campo de búsqueda
        trs.setRowFilter(RowFilter.regexFilter(campo_buscar.getText(), 1, 2, 3));
    }
});

// Se crea un TableRowSorter y se asigna al modelo de la tabla
trs = new TableRowSorter(modelo);
jtDatos.setRowSorter(trs);

    }//GEN-LAST:event_campo_buscarKeyTyped

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        // Declara una variable de conexión a la base de datos, inicialmente establecida como null
        Connection conexion = null;

        try {
            // Obtiene el índice de la fila seleccionada en la tabla
            int row = jtDatos.getSelectedRow();
            // Obtiene el valor de la celda en la primera columna de la fila seleccionada
            String celda = jtDatos.getModel().getValueAt(row, 0).toString();
            // Define la consulta SQL para eliminar el registro con el ID correspondiente
            String sql = "DELETE FROM artistas WHERE id = ?";
            // Muestra un cuadro de diálogo de confirmación para la eliminación del registro
            int opc = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar el registro?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) { // Si el usuario confirma la eliminación
                // Establece una conexión a la base de datos
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca_music", "root", "");
                // Prepara la consulta SQL para su ejecución
                PreparedStatement ps = conexion.prepareStatement(sql);
                // Establece el valor del parámetro en la consulta SQL para evitar la inyección SQL
                ps.setString(1, celda);
                // Ejecuta la consulta SQL para eliminar el registro
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) { // Si se eliminó el registro correctamente
                    JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
                    // Vuelve a cargar los datos en la tabla después de eliminar el registro
                    mostrarDatos();
                } else { // Si no se encontró el registro para eliminar
                    JOptionPane.showMessageDialog(null, "No se encontró el registro para eliminar");
                }
            }
        } catch (SQLException e) {
            // En caso de error de SQL, muestra un mensaje de error al usuario
            JOptionPane.showMessageDialog(null, "Hubo un error, intente nuevamente");
        } finally {
            // Cierra la conexión a la base de datos si está abierta
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejo de errores
                }
            }
        }

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarActionPerformed
        // Declarar una variable de tipo exportar_excel
        exportar_excel obj;

        try {
            // Crear una instancia de la clase exportar_excel
            obj = new exportar_excel();

            // Llamar al método exportarExcel() de la instancia obj para exportar los datos de la tabla a Excel
            obj.exportarExcel(jtDatos);
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la exportación de Excel
            System.out.println("Error al exportar datos a Excel");
        }

    }//GEN-LAST:event_btn_exportarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // Declara una conexión a la base de datos, inicialmente establecida como null
        Connection conexion = null;

        try {
            // Obtener el índice de la fila seleccionada en la tabla
            int row = jtDatos.getSelectedRow();
            // Obtener el valor del identificador (id) de la fila seleccionada en la tabla
            String id = jtDatos.getModel().getValueAt(row, 0).toString();
            // Obtener los valores actuales de título, artista y género de la fila seleccionada en la tabla
            String tituloActual = jtDatos.getModel().getValueAt(row, 1).toString();
            String artistaActual = jtDatos.getModel().getValueAt(row, 2).toString();
            String generoActual = jtDatos.getModel().getValueAt(row, 3).toString();

            // Solicitar al usuario los nuevos valores para cada campo
            String nuevoTitulo = JOptionPane.showInputDialog(this, "Ingrese el nuevo título", tituloActual);
            String nuevoArtista = JOptionPane.showInputDialog(this, "Ingrese el nuevo artista", artistaActual);
            String nuevoGenero = JOptionPane.showInputDialog(this, "Ingrese el nuevo género", generoActual);

            // Verificar si se ingresaron nuevos valores y no están vacíos
            if (nuevoTitulo != null && nuevoArtista != null && nuevoGenero != null
                    && !nuevoTitulo.isEmpty() && !nuevoArtista.isEmpty() && !nuevoGenero.isEmpty()) {

                // Definir la consulta SQL para actualizar el registro en la tabla "artistas"
                String sql = "UPDATE artistas SET titulo = ?, artista = ?, genero = ? WHERE id = ?";
                // Establecer una conexión a la base de datos
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca_music", "root", "");
                PreparedStatement ps = conexion.prepareStatement(sql);

                // Establecer los nuevos valores para cada campo en la consulta SQL
                ps.setString(1, nuevoTitulo);
                ps.setString(2, nuevoArtista);
                ps.setString(3, nuevoGenero);
                ps.setString(4, id);

                // Ejecutar la consulta SQL para actualizar el registro en la base de datos
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
                    // Volver a cargar los datos en la tabla después de actualizar el registro
                    mostrarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el registro para actualizar");
                }
            }
        } catch (SQLException e) {
            // En caso de error de SQL, mostrar un mensaje de error al usuario
            JOptionPane.showMessageDialog(null, "Hubo un error, intente nuevamente");
        } finally {
            // Cerrar la conexión a la base de datos en el bloque finally
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    // Manejar cualquier error al cerrar la conexión
                    e.printStackTrace();
                }
            }
        }


    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

// Establecer una conexión a la base de datos utilizando el método getConnection() que debe estar definido en otra parte del código.
        Connection conexion = getConnection();
        PreparedStatement ps = null;

// Definir la consulta SQL para insertar un nuevo registro de artista en la tabla "artistas"
        String sql = "insert into artistas(titulo, artista, genero) values(?,?,?);";

        try {
            // Preparar la consulta SQL para su ejecución
            ps = conexion.prepareStatement(sql);

            // Establecer los valores de los parámetros de la consulta SQL utilizando los datos ingresados por el usuario
            ps.setString(1, jtTitulo.getText());
            ps.setString(2, jtArtista.getText());
            ps.setString(3, jtGenero.getText());

            // Ejecutar la consulta SQL para insertar el nuevo registro de artista en la base de datos
            ps.executeUpdate();

            // Cerrar la conexión a la base de datos
            conexion.close();

            // Mostrar un mensaje de éxito al usuario utilizando un cuadro de diálogo emergente
            JOptionPane.showMessageDialog(null, "Artista guardado con éxito...");

            // Actualizar la visualización de los datos para reflejar el nuevo registro de artista
            mostrarDatos();

            // Limpiar los campos de texto después de insertar el registro
            jtTitulo.setText("");
            jtArtista.setText("");
            jtGenero.setText("");

        } catch (Exception e) {
            // En caso de error, imprimir un mensaje de error en la consola
            System.out.println("Error..." + e);
        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtIdActionPerformed

    private void jtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTituloActionPerformed

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
            java.util.logging.Logger.getLogger(registro_music.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro_music.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro_music.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro_music.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_exportar;
    private javax.swing.JTextField campo_buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlArtista;
    private javax.swing.JLabel jlGenero;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtArtista;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField jtGenero;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtTitulo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
