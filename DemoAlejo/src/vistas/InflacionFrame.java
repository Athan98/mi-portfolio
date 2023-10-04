package vistas;

import javax.swing.table.DefaultTableModel;
import data.*;
import entidades.Inflacion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
import static vistas.Demo.escritorio;
import javax.swing.JPanel;

public class InflacionFrame extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    JFreeChart grafico;
    Loading l = new Loading();
    Fondo fondo = new Fondo();
    Panel panel =new Panel();
    Panel2 panel2=new Panel2();

    public boolean isCellEditable(int fila, int col) {
        return false;
    }

    public InflacionFrame() {
        this.setContentPane(fondo);
        initComponents();
        armarCabeceraTabla();
        escritorio.moveToFront(l);
        escritorio.add(l);
        l.setVisible(false);
        centrarLoading(l);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInflacion = new javax.swing.JTable();
        jbBuscar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbGraficar = new javax.swing.JButton();
        jcInflacion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jpFechas = new javax.swing.JPanel();
        Fecha1LabelInflacionMensual = new javax.swing.JLabel();
        Fecha2LabelInflacionMensual = new javax.swing.JLabel();
        jtFecha1 = new javax.swing.JTextField();
        jtFecha2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new Panel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlTasaCalculada = new javax.swing.JLabel();
        jlFechaTasaCalculada = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtValorAnterior = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jbConvertirValor = new javax.swing.JButton();
        jlValorConvertido = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inflacion/Deflacion");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(326, 471));

        jtInflacion.setBackground(new java.awt.Color(66, 66, 66));
        jtInflacion.setForeground(new java.awt.Color(255, 255, 255));
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
        jtInflacion.setSelectionBackground(new java.awt.Color(0, 153, 204));
        jtInflacion.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jtInflacion);

        jbBuscar.setBackground(new java.awt.Color(66, 66, 66));
        jbBuscar.setForeground(new java.awt.Color(66, 66, 66));
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbBorrar.setBackground(new java.awt.Color(66, 66, 66));
        jbBorrar.setForeground(new java.awt.Color(66, 66, 66));
        jbBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jbGraficar.setBackground(new java.awt.Color(66, 66, 66));
        jbGraficar.setForeground(new java.awt.Color(66, 66, 66));
        jbGraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGraficarActionPerformed(evt);
            }
        });

        jcInflacion.setBackground(new java.awt.Color(66, 66, 66));
        jcInflacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jcInflacion.setForeground(new java.awt.Color(255, 255, 255));
        jcInflacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione un tipo-", "Inflacion mensual actual", "Inflacion mensual en un periodo", "Inflacion acumulada actual", "Inflacion acumulada en un periodo", "Inflacion Interanual actual", "Inflacion Interanual esperada" }));
        jcInflacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcInflacionItemStateChanged(evt);
            }
        });

        jpFechas.setBackground(new java.awt.Color(66, 66, 66));
        jpFechas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpFechas.setForeground(new java.awt.Color(66, 66, 66));
        jpFechas.setToolTipText("");

        Fecha1LabelInflacionMensual.setBackground(new java.awt.Color(255, 255, 255));
        Fecha1LabelInflacionMensual.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Fecha1LabelInflacionMensual.setForeground(new java.awt.Color(255, 255, 255));
        Fecha1LabelInflacionMensual.setText("Fecha anterior:");

        Fecha2LabelInflacionMensual.setBackground(new java.awt.Color(255, 255, 255));
        Fecha2LabelInflacionMensual.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Fecha2LabelInflacionMensual.setForeground(new java.awt.Color(255, 255, 255));
        Fecha2LabelInflacionMensual.setText("Fecha posterior:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingrese la/s fecha/s (yyyy-mm-dd)");

        javax.swing.GroupLayout jpFechasLayout = new javax.swing.GroupLayout(jpFechas);
        jpFechas.setLayout(jpFechasLayout);
        jpFechasLayout.setHorizontalGroup(
            jpFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addGroup(jpFechasLayout.createSequentialGroup()
                        .addGroup(jpFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fecha2LabelInflacionMensual)
                            .addComponent(Fecha1LabelInflacionMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtFecha1)
                            .addComponent(jtFecha2))
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jpFechasLayout.setVerticalGroup(
            jpFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha1LabelInflacionMensual)
                    .addComponent(jtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha2LabelInflacionMensual)
                    .addComponent(jtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jbGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcInflacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcInflacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(66, 66, 66));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(326, 471));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TASA (%):");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("FECHA (yyyy-mm-dd):");

        jlTasaCalculada.setBackground(new java.awt.Color(255, 255, 255));
        jlTasaCalculada.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlTasaCalculada.setForeground(new java.awt.Color(255, 255, 255));
        jlTasaCalculada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlFechaTasaCalculada.setBackground(new java.awt.Color(255, 255, 255));
        jlFechaTasaCalculada.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlFechaTasaCalculada.setForeground(new java.awt.Color(255, 255, 255));
        jlFechaTasaCalculada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel3.setBackground(new java.awt.Color(66, 66, 66));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(66, 66, 66));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial Narrow", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LO QUE ANTES VALÍA:");

        jbConvertirValor.setBackground(new java.awt.Color(66, 66, 66));
        jbConvertirValor.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jbConvertirValor.setForeground(new java.awt.Color(255, 255, 255));
        jbConvertirValor.setText("AHORA VALE...");
        jbConvertirValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConvertirValorActionPerformed(evt);
            }
        });

        jlValorConvertido.setBackground(new java.awt.Color(255, 255, 255));
        jlValorConvertido.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        jlValorConvertido.setForeground(new java.awt.Color(255, 255, 255));
        jlValorConvertido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbConvertirValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtValorAnterior))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlValorConvertido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtValorAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbConvertirValor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlValorConvertido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlFechaTasaCalculada, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlTasaCalculada, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFechaTasaCalculada, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTasaCalculada, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (jcInflacion.getSelectedItem().equals("-Seleccione un tipo-")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento de la lista");
        } else if (jcInflacion.getSelectedItem().equals("Inflacion mensual en un periodo")
                || jcInflacion.getSelectedItem().equals("Inflacion mensual actual")) {
            CargaInflacionMensual cargaInflacionMensual = new CargaInflacionMensual();
            cargaInflacionMensual.start();
        } else if (jcInflacion.getSelectedItem().equals("Inflacion acumulada actual")
                || jcInflacion.getSelectedItem().equals("Inflacion acumulada en un periodo")) {
            CargarInflacionAcumulada cia = new CargarInflacionAcumulada();
            cia.start();
        } else if (jcInflacion.getSelectedItem().equals("Inflacion Interanual actual")) {

            CargarInflacionInterAnual ciia = new CargarInflacionInterAnual();
            ciia.start();

        } else if (jcInflacion.getSelectedItem().equals("Inflacion Interanual esperada")) {

            CargarInflacionEsperada cie = new CargarInflacionEsperada();
            cie.start();
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGraficarActionPerformed
        ArrayList<String> fechas = new ArrayList<>();
        if (jcInflacion.getSelectedItem().equals("Inflacion mensual en un periodo")) {
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
                    "Fecha",
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

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        jtFecha1.setText("");
        jtFecha2.setText("");
        jcInflacion.setSelectedIndex(0);
        jlValorConvertido.setText("");
        jtValorAnterior.setText("");
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jcInflacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcInflacionItemStateChanged
        Fecha1LabelInflacionMensual.setVisible(true);
        jtFecha1.setEditable(true);
        jbGraficar.setEnabled(true);
        jbBorrar.setEnabled(true);
        Fecha2LabelInflacionMensual.setVisible(true);
        jtFecha2.setEditable(true);
        jpFechas.setVisible(true);
        jtFecha1.setText("");
        jtFecha2.setText("");
        jlFechaTasaCalculada.setText("");
        jlTasaCalculada.setText("");
        jlValorConvertido.setText("");
        jtValorAnterior.setText("");
        if (jcInflacion.getSelectedItem().equals("Inflacion mensual actual")) {
            jtFecha1.setEditable(false);
            jtFecha2.setEditable(false);
            jbGraficar.setEnabled(false);
            borrarFilas(modelo);
        } else if (jcInflacion.getSelectedItem().equals("Inflacion acumulada actual")) {
            jtFecha1.setEditable(false);
            jtFecha2.setEditable(false);
            jbGraficar.setEnabled(false);
            borrarFilas(modelo);
        } else if (jcInflacion.getSelectedItem().equals("Inflacion Interanual actual")) {
            jtFecha1.setEditable(false);
            jtFecha2.setEditable(false);
            jbGraficar.setEnabled(false);
            borrarFilas(modelo);
        } else if (jcInflacion.getSelectedItem().equals("Inflacion Interanual esperada")) {
            jtFecha1.setEditable(false);
            jtFecha2.setEditable(false);
            jbGraficar.setEnabled(false);
            borrarFilas(modelo);
        }
    }//GEN-LAST:event_jcInflacionItemStateChanged

    private void jbConvertirValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConvertirValorActionPerformed
        try {
            if (jtValorAnterior.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Debe ingresar un monto");
                jtValorAnterior.setText("");

            } else {

                Float montoConvertido = Float.parseFloat(jtValorAnterior.getText()) * Float.parseFloat(jlTasaCalculada.getText());
                DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Cambia el número de decimales según tus necesidades
                String montoConvertidoFormatted = decimalFormat.format(montoConvertido);

                jlValorConvertido.setText("$"+montoConvertidoFormatted);

            }
        } catch (NumberFormatException | NullPointerException e) {

            JOptionPane.showMessageDialog(this, "Llene el campo correctamente");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error. Intentelo nuevamente");
        }
    }//GEN-LAST:event_jbConvertirValorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fecha1LabelInflacionMensual;
    private javax.swing.JLabel Fecha2LabelInflacionMensual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbConvertirValor;
    private javax.swing.JButton jbGraficar;
    private javax.swing.JComboBox<String> jcInflacion;
    private javax.swing.JLabel jlFechaTasaCalculada;
    private javax.swing.JLabel jlTasaCalculada;
    private javax.swing.JLabel jlValorConvertido;
    private javax.swing.JPanel jpFechas;
    private javax.swing.JTextField jtFecha1;
    private javax.swing.JTextField jtFecha2;
    private javax.swing.JTable jtInflacion;
    private javax.swing.JTextField jtValorAnterior;
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

    public class CargaInflacionMensual extends Thread {

        @Override
        public void run() {
            l.setVisible(true);
            ConexionBancoCentral con = new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_mensual_oficial");
            BancoCentral_data inflacionMensual = new BancoCentral_data(con);
            l.setVisible(false);

            borrarFilas(modelo);

            try {
                if (jcInflacion.getSelectedItem().equals("Inflacion mensual en un periodo")) {

                    List<Inflacion> inflacionList = inflacionMensual.obtenerDatosEntreFechas(jtFecha1.getText(), jtFecha2.getText());
                    for (Inflacion inf : inflacionList) {
                        modelo.addRow(new Object[]{
                            inf.getFecha(),
                            inf.getTasa()
                        });
                    }

                } else if (jcInflacion.getSelectedItem().equals("Inflacion mensual actual")) {

                    Inflacion inflacion = inflacionMensual.obtenerInflacionActual();
                    jlFechaTasaCalculada.setText(inflacion.getFecha() + "");
                    jlTasaCalculada.setText(inflacion.getTasa() + "");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error. Vuelva a intentarlo");
                jtFecha1.setText("");
                jtFecha2.setText("");
                jcInflacion.setSelectedIndex(0);

            }

        }

        @Override
        public UncaughtExceptionHandler getUncaughtExceptionHandler() {
            return super.getUncaughtExceptionHandler(); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public class CargarInflacionAcumulada extends Thread {

        @Override
        public void run() {
            l.setVisible(true);
            ConexionBancoCentral con = new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_mensual_oficial");
            BancoCentral_data inflacion = new BancoCentral_data(con);
            l.setVisible(false);

            borrarFilas(modelo);
            double inflacionAcumulada = 0;
            try {
                if (jcInflacion.getSelectedItem().equals("Inflacion acumulada en un periodo")) {

                    List<Inflacion> inflacionList = inflacion.obtenerDatosEntreFechas(jtFecha1.getText(), jtFecha2.getText());
                    for (Inflacion inf : inflacionList) {
                        inflacionAcumulada = inflacionAcumulada + inf.getTasa();
                    }
                    jlFechaTasaCalculada.setText(" " + jtFecha1.getText() + " ---> " + jtFecha2.getText());
                    jlTasaCalculada.setText(inflacionAcumulada + "");

                } else if (jcInflacion.getSelectedItem().equals("Inflacion acumulada actual")) {

                    inflacionAcumulada = inflacion.obtenerInflacionAcumuladaActual();
                    jlFechaTasaCalculada.setText(LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()) + "");
                    jlTasaCalculada.setText(inflacionAcumulada + "");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error. Vuelva a intentarlo");
                jtFecha1.setText("");
                jtFecha2.setText("");
                jcInflacion.setSelectedIndex(0);
            }
        }
    }

    public class CargarInflacionInterAnual extends Thread {

        @Override
        public void run() {
            l.setVisible(true);
            ConexionBancoCentral con = new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_interanual_oficial");
            BancoCentral_data inflacion = new BancoCentral_data(con);
            l.setVisible(false);

            Inflacion inf = new Inflacion();

            borrarFilas(modelo);

            try {

                if (jcInflacion.getSelectedItem().equals("Inflacion Interanual actual")) {

                    inf = inflacion.obtenerInflacionInterAnual();
                    jlFechaTasaCalculada.setText(inf.getFecha() + "");
                    jlTasaCalculada.setText(inf.getTasa() + "");

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error. Vuelva a intentarlo");
                jtFecha1.setText("");
                jtFecha2.setText("");
                jcInflacion.setSelectedIndex(0);
            }

        }
    }

    public class CargarInflacionEsperada extends Thread {

        @Override
        public void run() {
            l.setVisible(true);
            ConexionBancoCentral con = new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_esperada_oficial");
            BancoCentral_data inflacion = new BancoCentral_data(con);
            l.setVisible(false);

            Inflacion inf = new Inflacion();

            borrarFilas(modelo);

            try {
                if (jcInflacion.getSelectedItem().equals("Inflacion Interanual esperada")) {

                    inf = inflacion.obtenerInflacionEsperada();
                    jlFechaTasaCalculada.setText(inf.getFecha() + "");
                    jlTasaCalculada.setText(inf.getTasa() + "");

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error. Vuelva a intentarlo");
                jtFecha1.setText("");
                jtFecha2.setText("");
                jcInflacion.setSelectedIndex(0);
            }
        }
    }

    private void centrarLoading(JInternalFrame intFrame) {
        int x = (escritorio.getWidth() / 2) - (intFrame.getWidth() / 2);
        int y = (escritorio.getHeight() / 2) - (intFrame.getHeight() / 2);
        intFrame.setLocation(x, y);

    }
    
    public class Fondo extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {

            imagen = new ImageIcon(getClass().getResource("/icons/fondoMacroeconomia.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
    
    public class Panel extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {

            imagen = new ImageIcon(getClass().getResource("/icons/muro-hormigon-negro.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
    
    public class Panel2 extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {

            imagen = new ImageIcon(getClass().getResource("/icons/fondoAcuarela.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
}
