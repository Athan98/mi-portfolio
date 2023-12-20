package frames;

public class Consultas extends javax.swing.JInternalFrame {

    ConsultasStock cs=new ConsultasStock();
    ConsultasPromociones cp=new ConsultasPromociones();
    ConsultaCodigos cc=new ConsultaCodigos();

    public Consultas() {
        initComponents();
        ConsultasPane.addTab("Consulta de codigo", cc);
        ConsultasPane.addTab("Consulta de stock", cs);
        ConsultasPane.addTab("Consulta de promos", cp);
        ConsultasPane.setSelectedComponent(cc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConsultasPane = new javax.swing.JTabbedPane();

        setClosable(true);
        setTitle("CONSULTAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsultasPane, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConsultasPane, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane ConsultasPane;
    // End of variables declaration//GEN-END:variables
}
