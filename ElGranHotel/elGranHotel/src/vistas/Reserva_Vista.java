/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Dimension;

/**
 *
 * @author Stefano
 */
public class Reserva_Vista extends javax.swing.JInternalFrame {

    CrearReserva RE = new CrearReserva();
    BuscarReservas BR = new BuscarReservas();
    
    public Reserva_Vista() {
        initComponents();
        PanelPrincipal.addTab("Crear Reserva", RE);
        PanelPrincipal.addTab("Buscar Reservas", BR);
        PanelPrincipal.setSelectedComponent(RE); 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        PanelPrincipal = new javax.swing.JTabbedPane();

        setClosable(true);
        setTitle("Reservas");
        setPreferredSize(new java.awt.Dimension(1200, 650));

        PanelPrincipal.setPreferredSize(new java.awt.Dimension(1120, 750));
        jScrollPane1.setViewportView(PanelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables


}
