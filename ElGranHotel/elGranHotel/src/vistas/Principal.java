/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.Conexion;
import data.Habitacion_data;
import data.Reserva_data;
import entidades.ReservaHuesped;
import entidades.Habitacion;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Principal extends javax.swing.JFrame {

    private Conexion con = new Conexion("jdbc:mariadb://localhost:3306/elgranhotel", "root", "");
    private Habitacion_data hd = new Habitacion_data(con);
    private Reserva_data rd = new Reserva_data(con);

    public Principal() {
        initComponents();
        actualizarReservas();
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        centrarPaneCheck();
        actualizarFechaHora();
        System.out.println(escritorio.getWidth());
        System.out.println(escritorio.getHeight());
        
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/texturaHormigon.jpg")); Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jlFechaHora = new javax.swing.JLabel();
        jpCheck = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmGestionHab = new javax.swing.JMenuItem();
        jReservas = new javax.swing.JMenu();
        jmReservas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("El gran hotel " + LocalDate.now().toString()
        );

        jlFechaHora.setBackground(new java.awt.Color(51, 51, 51));
        jlFechaHora.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jlFechaHora.setForeground(new java.awt.Color(255, 153, 51));
        jlFechaHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFechaHora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlFechaHora.setOpaque(true);

        jpCheck.setBackground(new java.awt.Color(51, 51, 51));
        jpCheck.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpCheck.setForeground(new java.awt.Color(51, 51, 51));
        jpCheck.setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movimiento diario");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHECK-IN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 2, 24), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 500));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHECK-OUT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 2, 24), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 500));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpCheckLayout = new javax.swing.GroupLayout(jpCheck);
        jpCheck.setLayout(jpCheckLayout);
        jpCheckLayout.setHorizontalGroup(
            jpCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpCheckLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpCheckLayout.setVerticalGroup(
            jpCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        escritorio.setLayer(jlFechaHora, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jpCheck, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jpCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));

        jMenu1.setBackground(new java.awt.Color(51, 51, 51));
        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setForeground(new java.awt.Color(51, 51, 51));
        jMenu1.setText("Huespedes");
        jMenu1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem1.setText("Gestión Huespedes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(51, 51, 51));
        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setText("Habitaciones");
        jMenu2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N

        jmGestionHab.setBackground(new java.awt.Color(51, 51, 51));
        jmGestionHab.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jmGestionHab.setForeground(new java.awt.Color(51, 51, 51));
        jmGestionHab.setText("Gestión Habitaciones");
        jmGestionHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionHabActionPerformed(evt);
            }
        });
        jMenu2.add(jmGestionHab);

        jMenuBar1.add(jMenu2);

        jReservas.setBackground(new java.awt.Color(51, 51, 51));
        jReservas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jReservas.setForeground(new java.awt.Color(51, 51, 51));
        jReservas.setText("Reservas");
        jReservas.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N

        jmReservas.setBackground(new java.awt.Color(51, 51, 51));
        jmReservas.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jmReservas.setForeground(new java.awt.Color(51, 51, 51));
        jmReservas.setText("Gestión Reservas");
        jmReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReservasActionPerformed(evt);
            }
        });
        jReservas.add(jmReservas);

        jMenuBar1.add(jReservas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmGestionHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionHabActionPerformed

        escritorio.repaint();
        Habitacion_vista hab = new Habitacion_vista();
        hab.setVisible(true);
        escritorio.add(hab);
        escritorio.moveToFront(hab);
        hab.setLocation((escritorio.getWidth() - hab.getWidth()) / 2, (escritorio.getHeight() - hab.getHeight()) / 2);
    }//GEN-LAST:event_jmGestionHabActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        escritorio.repaint();
        Huesped_vista h = new Huesped_vista();
        h.setVisible(true);
        escritorio.add(h);
        escritorio.moveToFront(h);
        h.setLocation((escritorio.getWidth() - h.getWidth()) / 2, (escritorio.getHeight() - h.getHeight()) / 2);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReservasActionPerformed

        escritorio.repaint();
        Reserva_Vista rv = new Reserva_Vista();
        rv.setVisible(true);
        escritorio.add(rv);
        escritorio.moveToFront(rv);
        rv.setLocation((escritorio.getWidth() - rv.getWidth()) / 2, (escritorio.getHeight() - rv.getHeight()) / 2);
    }//GEN-LAST:event_jmReservasActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu jReservas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel jlFechaHora;
    private javax.swing.JMenuItem jmGestionHab;
    private javax.swing.JMenuItem jmReservas;
    private javax.swing.JPanel jpCheck;
    // End of variables declaration//GEN-END:variables

    private void actualizarReservas() { //Cambia a "ocupadas" las habitaciones con reserva del dia
        List<ReservaHuesped> listareserva = new ArrayList<>();
        List<Habitacion> listahab = new ArrayList<>();

        listahab = hd.listarHabitaciones();
        listareserva = rd.buscarReservasXfecha(LocalDate.now(), LocalDate.now());

        rd.finReserva();

        for (Habitacion hab : listahab) {
            hd.modificarDisponibilidad(hab.getNroHabitacion(), hab.getPiso(), false);
        }

        for (ReservaHuesped reserva : listareserva) {
            hd.modificarDisponibilidad(reserva.getIdHabitacion().getNroHabitacion(), reserva.getIdHabitacion().getPiso(), true);
        }

    }

    //HILO PARA ESTABLECER Y ACTUALIZAR FECHA Y HORA
    private void actualizarFechaHora() {
        Thread reloj = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            while (true) {
                String fechaHora = sdf.format(new Date());
                SwingUtilities.invokeLater(() -> jlFechaHora.setText(fechaHora));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        reloj.start();
    }


    private void centrarPaneCheck() {
        
        Dimension d=new Dimension(500, 600);
        
        jpCheck.setPreferredSize(d); 

        int desktopWidth = escritorio.getWidth();
        int desktopHeight = escritorio.getHeight();
        int panelWidth = 500;
        int panelHeight = 600;

        int x = (desktopWidth - panelWidth) / 2;
        int y = (desktopHeight - panelHeight) / 2;

        jpCheck.setLocation(x, y);
    }
}
