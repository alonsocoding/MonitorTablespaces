/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Stroke;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;
import static monitor.Registros.modelo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.Layer;

/**
 *
 * @author josealonso
 */
public class MonitorFrame extends javax.swing.JFrame {

    // Lista para guardar tablespaces
    public List<Tablespace> tables = new ArrayList<Tablespace>();
    public static List<Table> table = new ArrayList<Table>();
    public static DefaultCategoryDataset sga_dataset = new DefaultCategoryDataset();
    // Atributos para definir los tablespaces seleccionados
    //public Registros view = new Registros();
    public static Registros view;
    static Connection conn = null;
    static Statement sta = null;
    static ResultSet res = null;
    static DefaultTableModel modelo = new DefaultTableModel();
    static DefaultTableModel modelo2 = new DefaultTableModel();

    /**
     * Creates new form MonitorFrame
     */
    public MonitorFrame() {
        initComponents();
        this.jTable1.setModel(modelo);
        modelo.addColumn("Tablespace");
        modelo.addColumn("Used MB");
        modelo.addColumn("Free MB");
        modelo.addColumn("Total MB");
        modelo.addColumn("Pct.Free");
        modelo.addColumn("HWM");
        modelo2.addColumn("Sentence");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monitor de los Tablespaces de Oracle");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Select");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Vani", 1, 24)); // NOI18N
        jLabel1.setText("Monitor de Tablespaces");

        jMenu1.setText("Menu");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Registros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(563, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // Lectura de Archivo para columna HWM
            String texto = "";
            FileReader lector = new FileReader("./archivo.txt");
            BufferedReader contenido = new BufferedReader(lector);
            // Conexion con base y lanza sql
            conn = Monitor.Enlace(conn);
            res = Monitor.TableRes(res);
            // Obtiene la cantidad de columnas
            ResultSetMetaData Res_md = res.getMetaData();
            int cantidad_columnas = Res_md.getColumnCount();
            // Agrega las columnas necesarias
            // Ingresa a la tabla las filas 
            while (res.next()) {
                Object[] fila = new Object[cantidad_columnas + 1];
                for (int i = 0; i < cantidad_columnas + 1; i++) {
                    if (i == cantidad_columnas) { // Si llega al final esta en HWM
                        texto = contenido.readLine(); // Lee archivo
                        fila[i] = texto; // Ingresa valor
                    } else { // Si no sigue en las otras columnas
                        fila[i] = res.getObject(i + 1); // Ingresa valor desde SQL
                    }
                }
                modelo.addRow(fila); // Ingresa la fila al table model
            }
            res.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jPanel1.removeAll();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int selectedRow = jTable1.getSelectedRow();
        //---------COdigo nuevo-------------------
        double var=0; //hasta limite 100%
        double var2=0; //hasta hwm
        double porcentaje=0; //porcentaje que tiene el hwm!
        String name = modelo.getValueAt(selectedRow, 0).toString();
        double promedioDiaU= users.transTableSpace();
        int libreU = Integer.parseInt(modelo.getValueAt(selectedRow, 2).toString());
        libreU = libreU *1024*1024;
        double diasU =  libreU / promedioDiaU ;
        double promedioDia= bschema.transTableSpace();
        int libre = Integer.parseInt(modelo.getValueAt(selectedRow, 2).toString());
        libre = libre *1024*1024;
        double dias =  libre / promedioDia;
        
        switch( name){
            case "USERS": 
                          var=  Math.round(diasU);
                          porcentaje= Double.parseDouble(modelo.getValueAt(selectedRow, 5).toString())/100;
                          var2= Math.round(libreU*porcentaje / promedioDiaU);
                          break;
            case "BSCHEMA": var=  Math.round(dias);
                            porcentaje= Double.parseDouble(modelo.getValueAt(selectedRow, 5).toString())/100;
                            var2= Math.round(libre*porcentaje / promedioDia);
                        break;
        
        }
        //Integer.parseInt(modelo.getValueAt(selectedRow, 2).toString()) /
        //-----------------------------------------------------------------------------------------------------------------

            
        dataset.addValue((Number) modelo.getValueAt(selectedRow, 1), "Used Space", modelo.getValueAt(selectedRow, 0).toString());
        dataset.addValue((Number) modelo.getValueAt(selectedRow, 2), "Free Space", modelo.getValueAt(selectedRow, 0).toString());

        JFreeChart chart = ChartFactory.createStackedBarChart("Tablespaces", "Name", "Space", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        jPanel1.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        jPanel1.add(CP, BorderLayout.CENTER);
        jPanel1.validate();

        int value = Integer.parseInt(modelo.getValueAt(selectedRow, 5).toString());
        int total = (Integer.parseInt(modelo.getValueAt(selectedRow, 3).toString()) * value) / 100;

        Stroke stroke = new BasicStroke(2.0f);
        ValueMarker marker = new ValueMarker(total);  // position is the value on the axis
        marker.setPaint(Color.yellow);
        marker.setStroke(stroke);

        CategoryPlot plot1 = chart.getCategoryPlot();
        plot1.addRangeMarker(marker, Layer.FOREGROUND);

        // get renderer
        StackedBarRenderer renderer = (StackedBarRenderer) chart.getCategoryPlot()
                .getRenderer();

        // set label appearance and position
        CategoryItemLabelGenerator lblGenerator = new StandardCategoryItemLabelGenerator();
        renderer.setBaseItemLabelGenerator(lblGenerator);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelPaint(Color.black);
          renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("<html>{0} <br> Tablespace {1} <br> {2} ({3}) <br> Dias restantes para llenar espacio total: "+ var+"<br>"
                + "Dias restantes para alcanzar hwm: "+var2+"</html>", NumberFormat.getInstance()));

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String ruta = "./archivo.txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < modelo.getRowCount(); i++) {
                bw.write(modelo.getValueAt(i, 5).toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        view.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

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
            java.util.logging.Logger.getLogger(MonitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonitorFrame().setVisible(true);
                view = new Registros();
            }
        });
        Thread t = new Thread(new Runnable() {
            public void run() {
                guardarRegistros();
                System.out.format("Termine...");
            }
        });
        t.start();

    }
    static int countRow = 2;
    static int constante = 100;
    
    public static void guardarRegistros() {
        try {
            // Ahi inserta la cantidad que diga
          /*  ResultSet inserts = null;
            conn = Monitor.Enlace(conn);
            inserts = Monitor.insertTest(10); // Cantidad
            */
            ResultSet tablespaces = null;
            conn = Monitor.Enlace(conn);
            tablespaces = Monitor.Res(tablespaces);
            File counter = new File("./count.txt");          
            String count = "0";
            if(counter.exists()) {
                BufferedReader bfr = new BufferedReader(new FileReader(counter));
                count = bfr.readLine(); // Lee archivo variable count
            }
            int count_num = Integer.parseInt(count);
            count_num += 1; // Suma uno y guarda en archivo
            BufferedWriter bfw = new BufferedWriter(new FileWriter(counter));
            bfw.write(count_num+"");
            bfw.close();
            countRow = count_num;
            File constante1 = new File("./count1.txt");          
            String count1 = "0";
            if(constante1.exists()) {
                BufferedReader bfr1 = new BufferedReader(new FileReader(constante1));
                count1 = bfr1.readLine(); // Lee archivo variable count
            }
            int count_num1 = Integer.parseInt(count1);
            count_num1 += 100; // Suma uno y guarda en archivo
            BufferedWriter bfw1 = new BufferedWriter(new FileWriter(constante1));
            bfw1.write(count_num1+"");
            bfw1.close();
            constante = count_num1;
            String t = "";
            //while (tablespaces.next()) {
            registros("USERS");
            creaMatriz("USERS");
            registros("BSCHEMA");
            /*t = tablespaces.getObject(1).toString();
             if (!t.contentEquals("UNDOTBS1") && !t.contentEquals("SYSTEM") && !t.contentEquals("SYSAUX")) {
                registros(t);*/
                
            creaMatriz("BSCHEMA");
            //}              
           //            }
            tablespaces.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void creaMatriz(String tablespace) {
        try {
            conn = Monitor.Enlace(conn);
            ResultSet count = null;
            count = Monitor.countTables(count, tablespace);
            int x = 0;
            if (tablespace != "SYSTEM" && tablespace != "SYSAUX") {
                while (count.next()) {
                    x = Integer.valueOf(count.getObject(1).toString());
                }
            }
            reading("./" + tablespace + ".txt", x);
            count.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Matriz system;
    static Matriz sysaux;
    static Matriz users;
    static Matriz bschema;

    public static void reading(String archivo, int columns) {
        try {
            String cadena;
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            boolean bandera;
            Matriz mat = new Matriz();
            switch (archivo) {
                
                case "./USERS.txt": {
                    users = new Matriz(countRow, columns);
                    while ((cadena = b.readLine()) != null) {
                Table t1 = new Table();

                StringTokenizer tokens = new StringTokenizer(cadena, ",");

                String name = tokens.nextToken().trim();
                String size = tokens.nextToken().trim();
                String registros = tokens.nextToken().trim();
                String index = tokens.nextToken().trim();

                if (registros == "null") {
                    registros = "0";
                }

                t1.setName(name);
                t1.setSize(Integer.parseInt(size));
                try {
                    t1.setRegistros(Integer.parseInt(registros));
                } catch (Exception e) {
                    t1.setRegistros(0);
                }

                try {
                    t1.setIndex(Integer.parseInt(index));
                } catch (Exception e1) {
                    t1.setIndex(0);
                }
                bandera = false;
                for (int i = 0; i < countRow; i++) {
                    if (bandera == true) {
                        break;
                    }
                    for (int j = 0; j < columns; j++) {
                        if (users.getPosicion(i, j).getName() == t1.getName()) {
                            users.agregarTabla(t1, i + 1, j);
                            bandera = true;
                            break;
                        } else {
                            if (users.getPosicion(i, j).getName() == "") {
                                users.agregarTabla(t1, i, j);
                                bandera = true;
                                break;
                            }
                        }
                    }
                }
            }
                    break;
                }
                case "./BSCHEMA.txt": {
                    bschema = new Matriz(countRow, columns);
                    while ((cadena = b.readLine()) != null) {
                Table t1 = new Table();

                StringTokenizer tokens = new StringTokenizer(cadena, ",");

                String name = tokens.nextToken().trim();
                String size = tokens.nextToken().trim();
                String registros = tokens.nextToken().trim();
                String index = tokens.nextToken().trim();

                if (registros == "null") {
                    registros = "0";
                }

                t1.setName(name);
                t1.setSize(Integer.parseInt(size));
                try {
                    t1.setRegistros(Integer.parseInt(registros));
                } catch (Exception e) {
                    t1.setRegistros(0);
                }

                try {
                    t1.setIndex(Integer.parseInt(index));
                } catch (Exception e1) {
                    t1.setIndex(0);
                }
                bandera = false;
                for (int i = 0; i < countRow; i++) {
                    if (bandera == true) {
                        break;
                    }
                    for (int j = 0; j < columns; j++) {
                        if (bschema.getPosicion(i, j).getName() == t1.getName()) {
                            bschema.agregarTabla(t1, i + 1, j);
                            bandera = true;
                            break;
                        } else {
                            if (bschema.getPosicion(i, j).getName() == "") {
                                bschema.agregarTabla(t1, i, j);
                                bandera = true;
                                break;
                            }
                        }
                    }
                }
            }
                    break;
                }
            }
            b.close();
            //System.out.println(system.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registros(String tablespace) {
        try {
            String ruta = "./" + tablespace + ".txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
            conn = Monitor.Enlace(conn);
            ResultSet tables = null;
            ResultSet sizeof = null;
            ResultSet registros = null;
            ResultSet index = null;
            String x = "";
            String y = "";
            String z = "";
            String w = "";
            bw = new BufferedWriter(new FileWriter(archivo, true));
            tables = Monitor.allTables(tables, tablespace);
            while (tables.next()) {
                try {
                    x = tables.getObject(1).toString();
                    sizeof = Monitor.sizeOfTable(res, x);
                    registros = Monitor.countRegister(res, x);
                    index = Monitor.sizeIndex(res, x);
                    while (sizeof.next()) {
                        y = sizeof.getObject(1).toString();
                    }
                } catch (Exception e) {
                    y = "2500";
                }
                try {
                    while (registros.next()) {
                        z = registros.getString(1);
                        if ("null".equals(z)) {
                            z = "0";
                        }
                    }
                } catch (Exception e) {
                    z = "0";
                }

                try {
                    while (index.next()) {
                        w = index.getString(1);
                        if (w == "null") {
                            w = "0";
                        }
                    }
                } catch (Exception e) {
                    w = "0";
                }
                Integer suma = Integer.parseInt(z) + constante;
                
                bw.write(x + "," + y + "," + suma.toString() + "," + w);
                bw.newLine();
            }
            bw.close();
            tables.close();
            sizeof.close();
            registros.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
