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
    // Atributos para definir los tablespaces seleccionados
    
    static Connection conn=null;
    static Statement sta=null;
    static ResultSet res=null;
    static DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form MonitorFrame
     */
    public MonitorFrame() {
        initComponents();
        this.jTable1.setModel(modelo);
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
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
            .addGap(0, 234, Short.MAX_VALUE)
        );

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar Registros");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(64, 64, 64)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
           // Lectura de Archivo para columna HWM
           String texto = "";
           FileReader lector=new FileReader("./archivo.txt");
           BufferedReader contenido=new BufferedReader(lector);
           // Conexion con base y lanza sql
           conn=Monitor.Enlace(conn);
           res=Monitor.TableRes(res);
           // Obtiene la cantidad de columnas
           ResultSetMetaData Res_md = res.getMetaData();
           int cantidad_columnas = Res_md.getColumnCount();
           // Agrega las columnas necesarias
           for(int i=1; i <= cantidad_columnas; i++) {
               modelo.addColumn(Res_md.getColumnLabel(i));
           }
           // Agrega una extra para HWM
           modelo.addColumn("HWM");
           // Ingresa a la tabla las filas 
           while(res.next()) {
               Object[] fila = new Object[cantidad_columnas+1];
               for(int i=0; i < cantidad_columnas+1; i++) {
                   if(i == cantidad_columnas) { // Si llega al final esta en HWM
                       texto = contenido.readLine(); // Lee archivo
                       fila[i] = texto; // Ingresa valor
                   } else { // Si no sigue en las otras columnas
                        fila[i] = res.getObject(i+1); // Ingresa valor desde SQL
                   }
               }
               modelo.addRow(fila); // Ingresa la fila al table model
           }
           res.close();
           conn.close();
           
       } catch(Exception e) {
           e.printStackTrace();
       }

       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jPanel1.removeAll();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int selectedRow = jTable1.getSelectedRow();

        dataset.addValue((Number) modelo.getValueAt(selectedRow, 1), "Used Space", modelo.getValueAt(selectedRow, 0).toString());
        dataset.addValue((Number) modelo.getValueAt(selectedRow, 2), "Free Space", modelo.getValueAt(selectedRow, 0).toString());
     
        
        JFreeChart chart = ChartFactory.createStackedBarChart("Tablespaces", "Name", "Space", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        jPanel1.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        jPanel1.add(CP,BorderLayout.CENTER);
        jPanel1.validate();
        
        int value = Integer.parseInt(modelo.getValueAt(selectedRow, 5).toString());
        int total = (Integer.parseInt(modelo.getValueAt(selectedRow, 3).toString()) * value) / 100;
   
        Stroke stroke = new BasicStroke(2.0f);
        ValueMarker marker = new ValueMarker(total);  // position is the value on the axis
        marker.setPaint(Color.yellow);
        marker.setStroke(stroke);

        CategoryPlot plot1 = chart.getCategoryPlot();
        plot1.addRangeMarker(marker,Layer.FOREGROUND);
        
        // get renderer
         StackedBarRenderer renderer = (StackedBarRenderer) chart.getCategoryPlot()
               .getRenderer();
         
         // set label appearance and position
         CategoryItemLabelGenerator lblGenerator = new StandardCategoryItemLabelGenerator();
         renderer.setBaseItemLabelGenerator(lblGenerator);
         renderer.setBaseItemLabelsVisible(true);
         renderer.setBaseItemLabelPaint(Color.black);
         renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("<html>{0} <br> Tablespace {1} <br> {2} ({3}) <br> Dias restantes : {2323} </html>", NumberFormat.getInstance()));

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
        String ruta = "./archivo.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));
        for(int i=0; i<modelo.getRowCount(); i++) {
            bw.write(modelo.getValueAt(i, 5).toString());
            bw.newLine();
        }
        bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   
        guardarRegistros();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            }
        });
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
               guardarRegistros();
            }
        });
    }
    
    public static void guardarRegistros(){
        try{
            ResultSet tablespaces = null;
            conn=Monitor.Enlace(conn);
            tablespaces = Monitor.Res(tablespaces);
            String t = "";
            while(tablespaces.next()){
                //registros("USERS");
                t = tablespaces.getObject(1).toString();
                if(!t.contentEquals("UNDOTBS1") ){
                    registros(t);
                }
            }
            tablespaces.close();
            conn.close();
        } catch(Exception e) {
           e.printStackTrace();
       }
    
    }
    
    public void reading(String archivo) {
		try {
			String cadena;
			FileReader f = new FileReader(archivo);
			BufferedReader b = new BufferedReader(f);
                        List list = new ArrayList();
                        List<Table> list1 = new ArrayList<Table>();
				while((cadena = b.readLine())!=null) {
					Table t1 = new Table();
					
					StringTokenizer tokens = new StringTokenizer(cadena, ","); 
					
					String name = tokens.nextToken().trim(); 
					String size = tokens.nextToken().trim(); 
					String registros = tokens.nextToken().trim();
					
					t1.setName(name);
					t1.setSize(Integer.parseInt(size));
					t1.setRegistros(Integer.parseInt(registros));
                                        
                                        
				}
			b.close();
		} catch(Exception e) {
			System.out.println("Error al leer...");
		}
	}
    
    public static void registros(String tablespace){
        try {
        String ruta = "./"+tablespace+".txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        conn=Monitor.Enlace(conn);
        ResultSet tables = null;
        ResultSet sizeof = null;
        ResultSet registros = null;
        String x ="";
        String y="";
        String z="";
        bw = new BufferedWriter(new FileWriter(archivo, true));
        tables = Monitor.allTables(tables, tablespace);
        while(tables.next()){
            try{
            x = tables.getObject(1).toString();
            sizeof = Monitor.sizeOfTable(res, x);
            registros = Monitor.countRegister(res, x);
           while(sizeof.next()){
            y = sizeof.getObject(1).toString();
            }
            }catch(Exception e){
                y = "2500";
            }
            
            while(registros.next()){
            z = registros.getString(1);
            if(z == "null"){
                z = "0";
            }
            }
            
            
            bw.write(x+ "," + y+ "," + z);
            bw.newLine();
        }
        bw.close();
        tables.close();
        sizeof.close();
        registros.close();
        conn.close();
    
       } catch(Exception e) {
           e.printStackTrace();
       }
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
