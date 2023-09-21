package vistas;

import javax.swing.table.DefaultTableModel;
import data.*;
import entidades.Inflacion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.labels.XYItemLabelGenerator;


/**
 *
 * @author Nicolas
 */
public class InflacionFrame extends javax.swing.JInternalFrame {
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    public boolean isCellEditable(int fila, int col) {
        return false;
    }
    
    JFreeChart grafico;

//    ConexionBancoCentral con2=new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_interanual_oficial");
//    ConexionBancoCentral con3=new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_esperada_oficial");
    public InflacionFrame() {
        initComponents();
        armarCabeceraTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtInflacion = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jrEntreFechayFecha = new javax.swing.JRadioButton();
        jrEntreFechayActualidad = new javax.swing.JRadioButton();
        jrActualidad = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbBuscar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbGraficar = new javax.swing.JButton();

        setClosable(true);

        jtInflacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtInflacion);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione un tipo-", "Inflacion mensual oficial", "Inflacion interanual oficial", "Inflacion esperada oficial" }));

        jrEntreFechayFecha.setText("Entre Fecha y Fecha");

        jrEntreFechayActualidad.setText("Entre Fecha y Actualidad");

        jrActualidad.setText("Actualidad");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingrese los datos para conocer Inflacion");

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N

        jbGraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrActualidad)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(178, 178, 178))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrEntreFechayActualidad)
                            .addComponent(jrEntreFechayFecha))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrActualidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrEntreFechayActualidad)
                .addGap(3, 3, 3)
                .addComponent(jrEntreFechayFecha)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGraficar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(221, 221, 221))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        
        try {
            borrarFilas(modelo);
            if (jrEntreFechayActualidad.isSelected() && jComboBox1.getSelectedItem().equals("Inflacion mensual oficial")) {
                jrActualidad.setSelected(false);
                jrEntreFechayFecha.setSelected(false);
                ConexionBancoCentral con = new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_mensual_oficial");
                BancoCentral_data inflacionMensual = new BancoCentral_data(con);
                
                String fechaIngresada = JOptionPane.showInputDialog("Ingrese la fecha anterior (yyyy-mm-dd)");
                DateTimeFormatter formatearFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate fechaFormat = LocalDate.parse(fechaIngresada, formatearFecha);
                Inflacion inflacion = new Inflacion();
                inflacion.setFecha(fechaFormat);
                List<Inflacion> inflacionList = inflacionMensual.obtenerDatosFechaAnteriorHastaActualidad(inflacion);
                for (Inflacion inf : inflacionList) {
                    modelo.addRow(new Object[]{
                        inf.getFecha(),
                        inf.getTasa()
                    });
                }
                
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Ingrese los datos correctamente");
        }
        

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGraficarActionPerformed
        ArrayList<String> fechas = new ArrayList<>();
        if (jrEntreFechayActualidad.isSelected() && jComboBox1.getSelectedItem().equals("Inflacion mensual oficial")) {
            XYSeries infMensual = new XYSeries("Inflacion mensual oficial");
            for (int i = 0; i < jtInflacion.getRowCount(); i++) {
                LocalDate fecha = (LocalDate) modelo.getValueAt(i, 0);
                Object tasa = modelo.getValueAt(i, 1);

                // Asegurarse de que fecha y tasa sean valores numéricos antes de agregarlos al gráfico
                if (fecha instanceof LocalDate && tasa instanceof Double) {
                    long fechaLong = fecha.toEpochDay();
                    infMensual.add(fechaLong, (Double) tasa);
                    LocalDate fechaLD = LocalDate.ofEpochDay(fechaLong);
                    String fechaFormat = fechaLD.format(DateTimeFormatter.ofPattern("yyyy/MM"));
                    fechas.add(fechaFormat);
                    
                }
                
            }
            
            XYSeriesCollection dataset = new XYSeriesCollection(infMensual);
            
            grafico = ChartFactory.createXYLineChart(
                    "Inflacion Mensual Oficial",
                    "Desde el: " + modelo.getValueAt(0, 0).toString() + ", hasta el: " + LocalDate.now(),
                    "Tasa",
                    dataset,
                    PlotOrientation.VERTICAL, true, true, true);
            
            XYPlot plot = grafico.getXYPlot();
            
              NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
              xAxis.setTickLabelsVisible(false);
            
            
            XYItemLabelGenerator generator = new XYItemLabelGenerator() {
                @Override
                public String generateLabel(XYDataset dataset, int series, int item) {
                    // Obtén el índice del array correspondiente al punto de datos actual
                    if (item >= 0 && item < fechas.size()) {
                        return fechas.get(item); // Devuelve la fecha del array como etiqueta
                    }
                    return ""; // Devuelve una cadena vacía si el índice está fuera de rango
                }
            };

            // Diseño de las líneas del gráfico
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setDefaultItemLabelGenerator(generator);
            renderer.setDefaultItemLabelsVisible(true);
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(2));
            
            plot.setRenderer(renderer);

            // Crear panel y mostrar el gráfico
            ChartPanel panel = new ChartPanel(grafico);
            
            JFrame ventana = new JFrame("Gráfica");
            ventana.setVisible(true);
            ventana.setSize(1000, 700);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
            
        }

    }//GEN-LAST:event_jbGraficarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGraficar;
    private javax.swing.JRadioButton jrActualidad;
    private javax.swing.JRadioButton jrEntreFechayActualidad;
    private javax.swing.JRadioButton jrEntreFechayFecha;
    private javax.swing.JTable jtInflacion;
    // End of variables declaration//GEN-END:variables

    public void armarCabeceraTabla() {
        
        modelo.addColumn("Fecha");
        modelo.addColumn("%");
        jtInflacion.setModel(modelo);
        
    }
    
    private void borrarFilas(DefaultTableModel modelo) {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
        
    }
    
}
