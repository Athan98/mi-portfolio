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

    Loading l = new Loading();

//    ConexionBancoCentral con2=new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_interanual_oficial");
//    ConexionBancoCentral con3=new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_esperada_oficial");
    public InflacionFrame() {
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInflacion = new javax.swing.JTable();
        jbBuscarInflacionMensual = new javax.swing.JButton();
        jbBorrarInflacionMensual = new javax.swing.JButton();
        jbGraficarInflacionMensual = new javax.swing.JButton();
        jtFecha2 = new javax.swing.JTextField();
        Fecha2Label = new javax.swing.JLabel();
        Fecha2Label1 = new javax.swing.JLabel();
        jtFecha1 = new javax.swing.JTextField();
        jcInflacionMensualOficial = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtInflacion2 = new javax.swing.JTable();
        jbBuscarInflacionMensual2 = new javax.swing.JButton();
        jbBorrarInflacionMensual2 = new javax.swing.JButton();
        jbGraficarInflacionMensual2 = new javax.swing.JButton();
        jtFecha5 = new javax.swing.JTextField();
        Fecha2Label4 = new javax.swing.JLabel();
        Fecha2Label5 = new javax.swing.JLabel();
        jtFecha6 = new javax.swing.JTextField();
        jcInflacionMensualOficial2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtInflacion1 = new javax.swing.JTable();
        jbBuscarInflacionMensual1 = new javax.swing.JButton();
        jbBorrarInflacionMensual1 = new javax.swing.JButton();
        jbGraficarInflacionMensual1 = new javax.swing.JButton();
        jtFecha3 = new javax.swing.JTextField();
        Fecha2Label2 = new javax.swing.JLabel();
        Fecha2Label3 = new javax.swing.JLabel();
        jtFecha4 = new javax.swing.JTextField();
        jcInflacionMensualOficial1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inflacion/Deflacion");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(326, 471));

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

        jbBuscarInflacionMensual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscarInflacionMensual.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscarInflacionMensual.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscarInflacionMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarInflacionMensualActionPerformed(evt);
            }
        });

        jbBorrarInflacionMensual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrarInflacionMensual.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrarInflacionMensual.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrarInflacionMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarInflacionMensualActionPerformed(evt);
            }
        });

        jbGraficarInflacionMensual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficarInflacionMensual.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficarInflacionMensual.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficarInflacionMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGraficarInflacionMensualActionPerformed(evt);
            }
        });

        Fecha2Label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Fecha2Label.setText("Fecha 2 (yyyy-mm-dd):");

        Fecha2Label1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Fecha2Label1.setText("Fecha 1 (yyyy-mm-dd):");

        jcInflacionMensualOficial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione un tipo-", "Actualidad", "Entre una fecha y la actualidad", "Entre fecha y fecha ingresadas", " " }));
        jcInflacionMensualOficial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcInflacionMensualOficialItemStateChanged(evt);
            }
        });

        jLabel1.setText("Inflacion/Deflacion Mensual Oficial");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcInflacionMensualOficial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Fecha2Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtFecha2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Fecha2Label1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtFecha1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbBuscarInflacionMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jbBorrarInflacionMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbGraficarInflacionMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcInflacionMensualOficial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha2Label1)
                    .addComponent(jtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha2Label)
                    .addComponent(jtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBorrarInflacionMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarInflacionMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGraficarInflacionMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(326, 471));

        jtInflacion2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jtInflacion2);

        jbBuscarInflacionMensual2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscarInflacionMensual2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscarInflacionMensual2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscarInflacionMensual2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarInflacionMensual2ActionPerformed(evt);
            }
        });

        jbBorrarInflacionMensual2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrarInflacionMensual2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrarInflacionMensual2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrarInflacionMensual2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarInflacionMensual2ActionPerformed(evt);
            }
        });

        jbGraficarInflacionMensual2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficarInflacionMensual2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficarInflacionMensual2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficarInflacionMensual2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGraficarInflacionMensual2ActionPerformed(evt);
            }
        });

        Fecha2Label4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Fecha2Label4.setText("Fecha 2 (yyyy-mm-dd):");

        Fecha2Label5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Fecha2Label5.setText("Fecha 1 (yyyy-mm-dd):");

        jcInflacionMensualOficial2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione un tipo-", "Actualidad", "Entre una fecha y la actualidad", "Entre fecha y fecha ingresadas", " " }));
        jcInflacionMensualOficial2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcInflacionMensualOficial2ItemStateChanged(evt);
            }
        });

        jLabel4.setText("Inflacion/Deflacion Mensual Oficial");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Fecha2Label4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtFecha5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcInflacionMensualOficial2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Fecha2Label5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtFecha6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jbBuscarInflacionMensual2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbBorrarInflacionMensual2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbGraficarInflacionMensual2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcInflacionMensualOficial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha2Label5)
                    .addComponent(jtFecha6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha2Label4)
                    .addComponent(jtFecha5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBorrarInflacionMensual2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarInflacionMensual2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGraficarInflacionMensual2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(326, 471));

        jtInflacion1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtInflacion1);

        jbBuscarInflacionMensual1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscarInflacionMensual1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscarInflacionMensual1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seo-social-web-network-internet_340_icon-icons.com_61497.png"))); // NOI18N
        jbBuscarInflacionMensual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarInflacionMensual1ActionPerformed(evt);
            }
        });

        jbBorrarInflacionMensual1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrarInflacionMensual1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrarInflacionMensual1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BORRAR.png"))); // NOI18N
        jbBorrarInflacionMensual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarInflacionMensual1ActionPerformed(evt);
            }
        });

        jbGraficarInflacionMensual1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficarInflacionMensual1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficarInflacionMensual1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graph_finance_growth_information_statistic_investment_progress_chart_data_icon_233836.png"))); // NOI18N
        jbGraficarInflacionMensual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGraficarInflacionMensual1ActionPerformed(evt);
            }
        });

        Fecha2Label2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Fecha2Label2.setText("Fecha 2 (yyyy-mm-dd):");

        Fecha2Label3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Fecha2Label3.setText("Fecha 1 (yyyy-mm-dd):");

        jcInflacionMensualOficial1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione un tipo-", "Actualidad", "Entre una fecha y la actualidad", "Entre fecha y fecha ingresadas", " " }));
        jcInflacionMensualOficial1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcInflacionMensualOficial1ItemStateChanged(evt);
            }
        });

        jLabel2.setText("Inflacion/Deflacion Mensual Oficial");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Fecha2Label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcInflacionMensualOficial1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Fecha2Label3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtFecha4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jbBuscarInflacionMensual1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbBorrarInflacionMensual1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbGraficarInflacionMensual1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcInflacionMensualOficial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha2Label3)
                    .addComponent(jtFecha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fecha2Label2)
                    .addComponent(jtFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBorrarInflacionMensual1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarInflacionMensual1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGraficarInflacionMensual1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(973, 973, 973))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarInflacionMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarInflacionMensualActionPerformed

        CargaInflacionMensual cargaInflacionMensual = new CargaInflacionMensual();
        cargaInflacionMensual.start();
    }//GEN-LAST:event_jbBuscarInflacionMensualActionPerformed

    private void jbGraficarInflacionMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGraficarInflacionMensualActionPerformed
        ArrayList<String> fechas = new ArrayList<>();
        if (jcInflacionMensualOficial.getSelectedItem().equals("Entre una fecha y la actualidad")) {
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

        }else if(jcInflacionMensualOficial.getSelectedItem().equals("Entre fecha y fecha ingresadas")){
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

    }//GEN-LAST:event_jbGraficarInflacionMensualActionPerformed

    private void jbBorrarInflacionMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarInflacionMensualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBorrarInflacionMensualActionPerformed

    private void jcInflacionMensualOficialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcInflacionMensualOficialItemStateChanged
        if (jcInflacionMensualOficial.getSelectedItem().equals("Entre una fecha y la actualidad")) {
            Fecha2Label1.setVisible(true);
            jtFecha1.setVisible(true);
            jbGraficarInflacionMensual.setEnabled(true);
            jbBorrarInflacionMensual.setEnabled(true);
            Fecha2Label.setVisible(false);
            jtFecha2.setVisible(false);
        } else if (jcInflacionMensualOficial.getSelectedItem().equals("Actualidad")) {
            Fecha2Label.setVisible(false);
            Fecha2Label1.setVisible(false);
            jtFecha1.setVisible(false);
            jtFecha2.setVisible(false);
            jbGraficarInflacionMensual.setEnabled(false);
            jbBorrarInflacionMensual.setEnabled(false);
        } else {
            Fecha2Label.setVisible(true);
            Fecha2Label1.setVisible(true);
            jtFecha1.setVisible(true);
            jtFecha2.setVisible(true);
            jbGraficarInflacionMensual.setEnabled(true);
            jbBorrarInflacionMensual.setEnabled(true);
        }

    }//GEN-LAST:event_jcInflacionMensualOficialItemStateChanged

    private void jbBuscarInflacionMensual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarInflacionMensual1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarInflacionMensual1ActionPerformed

    private void jbBorrarInflacionMensual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarInflacionMensual1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBorrarInflacionMensual1ActionPerformed

    private void jbGraficarInflacionMensual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGraficarInflacionMensual1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbGraficarInflacionMensual1ActionPerformed

    private void jcInflacionMensualOficial1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcInflacionMensualOficial1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcInflacionMensualOficial1ItemStateChanged

    private void jbBuscarInflacionMensual2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarInflacionMensual2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarInflacionMensual2ActionPerformed

    private void jbBorrarInflacionMensual2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarInflacionMensual2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBorrarInflacionMensual2ActionPerformed

    private void jbGraficarInflacionMensual2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGraficarInflacionMensual2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbGraficarInflacionMensual2ActionPerformed

    private void jcInflacionMensualOficial2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcInflacionMensualOficial2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcInflacionMensualOficial2ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fecha2Label;
    private javax.swing.JLabel Fecha2Label1;
    private javax.swing.JLabel Fecha2Label2;
    private javax.swing.JLabel Fecha2Label3;
    private javax.swing.JLabel Fecha2Label4;
    private javax.swing.JLabel Fecha2Label5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBorrarInflacionMensual;
    private javax.swing.JButton jbBorrarInflacionMensual1;
    private javax.swing.JButton jbBorrarInflacionMensual2;
    private javax.swing.JButton jbBuscarInflacionMensual;
    private javax.swing.JButton jbBuscarInflacionMensual1;
    private javax.swing.JButton jbBuscarInflacionMensual2;
    private javax.swing.JButton jbGraficarInflacionMensual;
    private javax.swing.JButton jbGraficarInflacionMensual1;
    private javax.swing.JButton jbGraficarInflacionMensual2;
    private javax.swing.JComboBox<String> jcInflacionMensualOficial;
    private javax.swing.JComboBox<String> jcInflacionMensualOficial1;
    private javax.swing.JComboBox<String> jcInflacionMensualOficial2;
    private javax.swing.JTextField jtFecha1;
    private javax.swing.JTextField jtFecha2;
    private javax.swing.JTextField jtFecha3;
    private javax.swing.JTextField jtFecha4;
    private javax.swing.JTextField jtFecha5;
    private javax.swing.JTextField jtFecha6;
    private javax.swing.JTable jtInflacion;
    private javax.swing.JTable jtInflacion1;
    private javax.swing.JTable jtInflacion2;
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

        public void run() {
            l.setVisible(true);
            ConexionBancoCentral con = new ConexionBancoCentral("https://api.estadisticasbcra.com/inflacion_mensual_oficial");
            BancoCentral_data inflacionMensual = new BancoCentral_data(con);
            l.setVisible(false);

            borrarFilas(modelo);
            if (jcInflacionMensualOficial.getSelectedItem().equals("Entre una fecha y la actualidad")) {
                String fechaIngresada = jtFecha1.getText();
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

            }else if(jcInflacionMensualOficial.getSelectedItem().equals("Entre fecha y fecha ingresadas")){
            
                List<Inflacion> inflacionList =inflacionMensual.obtenerDatosEntreFechas(jtFecha1.getText(), jtFecha2.getText());
                for (Inflacion inf : inflacionList) {
                    modelo.addRow(new Object[]{
                        inf.getFecha(),
                        inf.getTasa()
                    });
                }
                
                
            }else if(jcInflacionMensualOficial.getSelectedItem().equals("Actualidad")){
                
                Inflacion inflacion=inflacionMensual.obtenerInflacionActual();
                JOptionPane.showMessageDialog(null, inflacion.toString());
            
            }

        }

    }

    private void centrarLoading(JInternalFrame intFrame) {
        int x = (escritorio.getWidth() / 2) - (intFrame.getWidth() / 2);
        int y = (escritorio.getHeight() / 2) - (intFrame.getHeight() / 2);
        intFrame.setLocation(x, y);

    }
}
