package frames;



public class Pedidos extends javax.swing.JInternalFrame {

    IngresarPedido ip = new IngresarPedido();
    ActualizarStock as = new ActualizarStock();
    GestionPedidosExistentes gpe=new GestionPedidosExistentes();

    public Pedidos() {
        initComponents();
        PanelPedidos.addTab("Nuevos pedidos", ip);
        PanelPedidos.addTab("Pedidos existentes", gpe);
        PanelPedidos.addTab("Actualizar stock´s", as);
        PanelPedidos.setSelectedComponent(ip);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPedidos = new javax.swing.JTabbedPane();

        setClosable(true);
        setTitle("PEDIDOS");
        setPreferredSize(new java.awt.Dimension(980, 600));

        PanelPedidos.setPreferredSize(new java.awt.Dimension(980, 600));
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
                .addComponent(PanelPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelPedidosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PanelPedidosStateChanged
        as.borrarFilas();
        as.actualizarListaProductos();
        gpe.borrarFilas();
        gpe.actualizarListaPedidos();
    }//GEN-LAST:event_PanelPedidosStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanelPedidos;
    // End of variables declaration//GEN-END:variables

}
