package monitor;

import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Monitor {
    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    
    static String bd = "XE";
    static String username = "myuser";
    static String password = "macros98";
    static String url = "jdbc:oracle:thin:@alonso-PC:1521:XE";
    
    public static Connection Enlace(Connection conn) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection(url, username, password);
        } catch(ClassNotFoundException e) {
            System.out.print("Clase no encontrada...");
        }
        return conn;
    }
    
    public static Statement Sta(Statement st) throws SQLException {
        conn = Enlace(conn);
        st = conn.createStatement();
        return st;
    }
    public static ResultSet Res(ResultSet rs) throws SQLException {
        st = Sta(st);
        rs = st.executeQuery("select * from student");
        return rs;
    }
    
}
