/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bânbân
 */
public class DBConnection {// Lớp này giải quyết kết nối xử lý truy vấn

    private static String hostName = "localhost";
    private static String acc = "sa";
    private static String pass = "123456";
    private static String dbName = "FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041";
    private static String connectionSql
            = "jdbc:sqlserver://" + hostName + ":1433;databaseName=" + dbName;
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection conn;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi Driver");
        }
    }

    //1. Mở kết nối
    public static Connection openDbConnection() {
        try {
            return DriverManager.getConnection(connectionSql, acc, pass);
        } catch (SQLException ex) {
            return null;
        }
    }

}
