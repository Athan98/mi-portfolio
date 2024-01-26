package frames;



public class Pedidos extends javax.swing.JInternalFrame {

    IngresarPedido ip = new IngresarPedido();
    ActualizarStock as = new ActualizarStock();

    public Pedidos() {
        initComponents();
        PanelPedidos.addTab("Nuevo ingreso", ip);
        PanelPedidos.addTab("Actualizar stock´s", as);
        PanelPedidos.setSelectedComponent(ip);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPedidos = new javax.swing.JTabbedPane();

        setClosable(true);
        setTitle("PEDIDOS");
        setPreferredSize(new java.awt.Dimension(590, 600));

        PanelPedidos.setPreferredSize(new java.awt.Dimension(570, 590));
        PanelPedidos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PanelPedidosStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelPedidosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PanelPedidosStateChanged
        as.borrarFilas();
        as.actualizarListaProductos();
    }//GEN-LAST:event_PanelPedidosStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanelPedidos;
    // End of variables declaration//GEN-END:variables

}
