/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author h
 */
public class KoneksiDatabase {
    private static Connection conn;
    private static Statement statement;
    private static final String db_url = "jdbc:mysql://localhost:3306/uaspbo";
    private static final String username = "root";
    private static final String password = "";
    private static final String driverName = "com.mysql.jdbc.Driver";
    
    
    
    // function untuk mendapatkan / membuka koneksi
    public static Connection dapatkanKoneksi() {
        try {
            Class.forName(driverName);
            try {
                conn = DriverManager.getConnection(db_url, username, password);
            } catch (SQLException ex) {
                System.out.println("Koneksi ke database gagal!"); 
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver tidak ditemukan!"); 
        }
        return conn;
    }
    
    // function untuk menutup koneksi database
    public static Connection tutupKoneksi(){
        try{
            conn.close();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "koneksi gagal ditutup!");
        }
        return conn;
    }
}
