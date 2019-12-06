/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.KoneksiDatabase;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author h
 */
public class QueryDatabase {
    // berisi function2 untuk melakukan query di database
    
    private static ResultSet rs;
    private static Statement st;
    private static Connection conn;
    private static String sql;
    private static int hasil;
    
    
    // statement eksekusi query (untuk SELECT)
    public static ResultSet eksekusiQuery(String sql){
        try{
            conn = KoneksiDatabase.dapatkanKoneksi();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
    // statement eksekusi update (untuk INSERT, UPDATE, DELETE)
    public static int eksekusiUpdate(String sql){
        try{
            conn = KoneksiDatabase.dapatkanKoneksi();
            st = conn.createStatement();
            hasil = st.executeUpdate(sql); 
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return hasil;
    }
     
    
    
    
    
    // statement SELECT
    public static ResultSet querySelectSemua(String namaTabel){
        sql = "SELECT * FROM " + namaTabel;
        return eksekusiQuery(sql);
    }
    
    
    
    // statement DELETE
    public static int queryHapus(String namaTabel, String kondisi) {
        sql = "DELETE FROM " + namaTabel + " WHERE " + kondisi;
        return eksekusiUpdate(sql);
    }
    
    
    // statement INSERT
    public static int queryMasukan(String namaTabel, String[] namaKolom, String[] isiTabel){
        sql = "INSERT INTO " + namaTabel + " (";
        for(int i = 0; i <= namaKolom.length - 1; i++){
            sql += namaKolom[i];
            if (i < namaKolom.length - 1) {
                sql += ",";
            }
        }
        sql += ") VALUES (";
        for (int i = 0; i <= isiTabel.length - 1; i++) {
            sql += "'" + isiTabel[i] + "'";
            if (i < isiTabel.length - 1) {
                sql += ",";
            }
        }
        sql += ")";
        return eksekusiUpdate(sql);
    }
    
    
}
