/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.archivospeliculas.formularios;

import com.mycompany.archivospeliculas.ArchivosPeliculas;
import com.mycompany.archivospeliculas.ColeccionPeliculas;
import com.mycompany.archivospeliculas.Pelicula;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emili
 */
public class Frm_MostrarPeliculas extends javax.swing.JFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    private ColeccionPeliculas colec;

    /**
     * Creates new form Frm_MostrarPeliculas
     */
    public Frm_MostrarPeliculas(ColeccionPeliculas coleccionPeliculas) {
        initComponents();
        colec = coleccionPeliculas;
        cargaPeliculas();
        this.setTitle(ArchivosPeliculas.getUsuarioNombre());
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public void cargaPeliculas() {
        ArrayList<Object> nombreColumna = new ArrayList<>();
        nombreColumna.add("Identificador");
        nombreColumna.add("Nombre");
        nombreColumna.add("Actor Principal");
        nombreColumna.add("Género");
        nombreColumna.add("Duración en minutos");
        for (Object columna : nombreColumna) {
            modelo.addColumn(columna);
        }
        
        jT_tablaPelis.setModel(modelo);
        
        ArrayList<Object[]> datos = new ArrayList<>();
        for (int i = 0; i < colec.tamanio(); ++i){
            Pelicula p = colec.obtener(i);
            Object[] info = new Object[]{p.getIdentificador(), p.getNombre(), p.getActorPrincipal(), p.getGenero(), p.getDuracion()};
            modelo.addRow(info);
        }
        
        jT_tablaPelis.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jT_tablaPelis = new javax.swing.JTable();
        jL_cerrar = new javax.swing.JButton();
        jB_ordNombre = new javax.swing.JButton();
        jB_ordDuracion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jT_tablaPelis.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jT_tablaPelis);

        jL_cerrar.setText("Cerrar");
        jL_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jL_cerrarActionPerformed(evt);
            }
        });

        jB_ordNombre.setText("Ordenar por nombre");
        jB_ordNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ordNombreActionPerformed(evt);
            }
        });

        jB_ordDuracion.setText("Ordenar por duración");
        jB_ordDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ordDuracionActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de Películas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(253, 253, 253))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jL_cerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jB_ordNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jB_ordDuracion)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_cerrar)
                    .addComponent(jB_ordNombre)
                    .addComponent(jB_ordDuracion))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jL_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jL_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jL_cerrarActionPerformed

    private void jB_ordNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ordNombreActionPerformed
        DefaultTableModel modelo = (DefaultTableModel)jT_tablaPelis.getModel();
        modelo.setRowCount(0);
        
        ArrayList<Object[]> datos = new ArrayList<>();
        ArrayList<Pelicula> colecOrdenada = colec.ordenarPorNombre();
        for (Pelicula p : colecOrdenada) {
            Object[] info = new Object[]{p.getIdentificador(), p.getNombre(), p.getActorPrincipal(), p.getGenero(), p.getDuracion()};
            modelo.addRow(info);
        }
        
        jT_tablaPelis.setModel(modelo);
    }//GEN-LAST:event_jB_ordNombreActionPerformed

    private void jB_ordDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ordDuracionActionPerformed
        DefaultTableModel modelo = (DefaultTableModel)jT_tablaPelis.getModel();
        modelo.setRowCount(0);
        
        ArrayList<Object[]> datos = new ArrayList<>();
        ArrayList<Pelicula> colecOrdenada = colec.ordenarPorDuracionInverso();
        for (Pelicula p : colecOrdenada) {
            Object[] info = new Object[]{p.getIdentificador(), p.getNombre(), p.getActorPrincipal(), p.getGenero(), p.getDuracion()};
            modelo.addRow(info);
        }
        
        jT_tablaPelis.setModel(modelo);
    }//GEN-LAST:event_jB_ordDuracionActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_ordDuracion;
    private javax.swing.JButton jB_ordNombre;
    private javax.swing.JButton jL_cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jT_tablaPelis;
    // End of variables declaration//GEN-END:variables
}
