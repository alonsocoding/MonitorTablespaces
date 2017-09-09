package monitor;

import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Monitor {

    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;

    static String bd = "XE";
    static String username = "bases";
    static String password = "bases";
    static String url = "jdbc:oracle:thin:@LAPTOP-I8IV3KN9:1522:XE";

    public static Connection Enlace(Connection conn) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
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
        rs = st.executeQuery("select tablespace_name from dba_segments group by tablespace_name");
        return rs;
    }

    public static ResultSet TableRes(ResultSet rs) throws SQLException {
        st = Sta(st);
        rs = st.executeQuery("select df.tablespace_name \"Tablespace\",\n"
                + "       totalusedspace \"Used MB\",\n"
                + "       (df.totalspace - tu.totalusedspace) \"Free MB\",\n"
                + "       df.totalspace \"Total MB\",\n"
                + "       round(100 * ( (df.totalspace - tu.totalusedspace)/ df.totalspace)) \"Pct. Free\"\n"
                + "  from (select tablespace_name,\n"
                + "               round(sum(bytes) / 1048576) TotalSpace\n"
                + "          from dba_data_files \n"
                + "         group by tablespace_name) df,\n"
                + "       (select round(sum(bytes)/(1024*1024)) totalusedspace,\n"
                + "               tablespace_name\n"
                + "          from dba_segments \n"
                + "         group by tablespace_name) tu\n"
                + " where df.tablespace_name = tu.tablespace_name \n"
                + "   and df.totalspace <> 0");
        return rs;
    }

    public static ResultSet allTables(ResultSet rs, String tablespace) throws SQLException {
        st = Sta(st);
        rs = st.executeQuery("select table_name FROM dba_tables where tablespace_name='" + tablespace + "'");
        return rs;
    }

    public static ResultSet sizeOfTable(ResultSet rs, String table) throws SQLException {
        st = Sta(st);
        rs = st.executeQuery("select SUM(data_length) from all_tab_columns where table_name = '" + table + "'");
        return rs;
    }

    public static ResultSet countRegister(ResultSet rs, String table) throws SQLException {
        st = Sta(st);
        rs = st.executeQuery("select num_rows FROM dba_tables where table_name = '" + table + "'");
        //exec dbms_stats.gather_schema_stats('system'); hacer lo mismo con el owner deseado
        return rs;
    }
    
    public static ResultSet countTables(ResultSet rs, String tablespace) throws SQLException {
        st = Sta(st);
        rs = st.executeQuery("select count(*) from dba_tables where tablespace_name='" + tablespace + "'");
        return rs;
    }
    
    public static ResultSet sizeIndex(ResultSet rs, String table) throws SQLException {
        st = Sta(st);
        rs = st.executeQuery("select SUM(column_length) from all_ind_columns where table_name = '"+ table+ "'");
        return rs;
    }

}
