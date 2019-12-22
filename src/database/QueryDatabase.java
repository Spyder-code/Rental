/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.*;
import javax.swing.JOptionPane;
//--------
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
    //--------
    private static FileInputStream inputStream;
    private static PreparedStatement ps;
    
    
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
     
    //-------------------------------------------------------
    
    
    
    
    
    // ------------------------------------ statement SELECT
    public static ResultSet querySelectSemua(String namaTabel){
        sql = "SELECT * FROM " + namaTabel;
        return eksekusiQuery(sql);
    }
    
<<<<<<< HEAD
     public static ResultSet querySelectKondisi(String namaTabel, String kondisi){
=======
    public static ResultSet querySelectSemua(String namaTabel, String kondisi){
>>>>>>> refs/remotes/origin/master
        sql = "SELECT * FROM " + namaTabel + " WHERE " + kondisi;
        return eksekusiQuery(sql);
    }
    
<<<<<<< HEAD
    // statement DELETE
=======
    // ------------------------------------ statement DELETE
>>>>>>> refs/remotes/origin/master
    public static int queryHapus(String namaTabel, String kondisi) {
        sql = "DELETE FROM " + namaTabel + " WHERE " + kondisi;
        return eksekusiUpdate(sql);
    }
    
    // ------------------------------------ statement INSERT
    public static int queryMasukan(String namaTabel, String[] namaKolom, String[] isiKolom){
        sql = "INSERT INTO " + namaTabel + " (";
        for(int i = 0; i <= namaKolom.length - 1; i++){
            sql += namaKolom[i];
            if (i < namaKolom.length - 1) {
                sql += ",";
            }
        }
        sql += ") VALUES (";
        for (int i = 0; i <= isiKolom.length - 1; i++) {
            sql += "'" + isiKolom[i] + "'";
            if (i < isiKolom.length - 1) {
                sql += ",";
            }
        }
        sql += ")";
        return eksekusiUpdate(sql);
    }
    
    public static int queryMasukan(String namaTabel, String[] namaKolom, String[] isiKolom, String namaGambar) throws FileNotFoundException, SQLException, IOException{
        File gambar = new File(namaGambar);
        inputStream = new FileInputStream(gambar);
        conn = KoneksiDatabase.dapatkanKoneksi();
        sql = "INSERT INTO " + namaTabel + " (";
        for(int i = 0; i <= namaKolom.length - 1; i++){
            sql += namaKolom[i];
            if (i < namaKolom.length - 1) {
                sql += ",";
            }
        }
        sql += ") VALUES (";
        for(int i = 0; i <= namaKolom.length - 1; i++){
            sql += "?";
            if (i < namaKolom.length - 1) {
                sql += ",";
            }
        }
        sql += ")";
        ps = conn.prepareStatement(sql);
        String ekstensi = "";
        for(int i = 0; i <= isiKolom.length - 1; i++){
            int x = isiKolom[i].lastIndexOf('.');
            if(x > 0){
                ekstensi = isiKolom[i].substring(x + 1);
            }
            if(ekstensi.equals("jpg") || ekstensi.equals("png") || ekstensi.equals("jpeg")){
                ps.setBinaryStream(i+1, (InputStream) inputStream, (int)(gambar.length()));
            } else {
                ps.setString(i+1, isiKolom[i]);
            }
        } 
        return ps.executeUpdate(); 
    }
    
    
    
    // ------------------------------------ statement UPDATE
    public static int queryUpdate(String namaTabel, String[] namaKolom, String[] isiKolom, String kondisi){
        sql = "UPDATE " + namaTabel + " SET ";
        for (int i = 0; i <= namaKolom.length - 1; i++) {
            sql += namaKolom[i] + "='" + isiKolom[i] + "'";
            if (i < namaKolom.length - 1) {
                sql += ", ";
            }
        }
        sql += " WHERE " + kondisi;
        return eksekusiUpdate(sql);
    }
    
    public static int queryUpdate(String namaTabel, String[] namaKolom, String[] isiKolom, String namaGambar, String kondisi) throws FileNotFoundException, SQLException{
        File gambar = new File(namaGambar);
        inputStream = new FileInputStream(gambar);
        conn = KoneksiDatabase.dapatkanKoneksi();
        sql = "UPDATE " + namaTabel + " SET ";
        for (int i = 0; i <= namaKolom.length - 1; i++) {
            sql += namaKolom[i] + "='?'";
            if (i < namaKolom.length - 1) {
                sql += ", ";
            }
        }       
        ps = conn.prepareStatement(sql);
        String ekstensi = "";
        for(int i = 0; i <= isiKolom.length - 1; i++){
            int x = isiKolom[i].lastIndexOf('.');
            if(x > 0){
                ekstensi = isiKolom[i].substring(x + 1);
            }
            if(ekstensi.equals("jpg") || ekstensi.equals("png") || ekstensi.equals("jpeg")){
                ps.setBinaryStream(i+1, (InputStream) inputStream, (int)(gambar.length()));
            } else {
                ps.setString(i+1, isiKolom[i]);
            }
        } 
        return ps.executeUpdate(); 
    }
    
    
}
