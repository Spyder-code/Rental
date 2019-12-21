/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import admin.TambahKendaraan;
import admin.AdminLogin;
import javax.swing.JOptionPane;
import database.*;
import java.awt.HeadlessException;
import java.sql.*;
/**
 *
 * @author h
 */
public class Admin {
    
    private String nama;
    private final String username;
    private final String password;
    private int hasil;
    
    private ResultSet rs;
    
    
    
    public Admin(String nama, String username, String password){
        this.nama = nama;
        this.username = username;
        this.password = password;
    }
    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    
    public void AdminLogin(){
        try {
            rs = QueryDatabase.querySelectSemua("admin");
            while(rs.next()){
                String user = rs.getString("username");
                String pass = rs.getString("password");
                if(this.username.equals(user) && this.password.equals(pass)){
                    JOptionPane.showMessageDialog(null, "login berhasil");
                    new TambahKendaraan().setVisible(true);
                    break;
                } else {
                    continue;
                }
            }
            KoneksiDatabase.tutupKoneksi();
        } catch(SQLException | HeadlessException ex){
            JOptionPane.showMessageDialog(null, ex); 
        }
        
    }
    
    public void RegisterAdmin(String[] namaKolom){
        String[] isiKolom = {this.nama, this.username, this.password};
        try {
            hasil = QueryDatabase.queryMasukan("admin", namaKolom, isiKolom);
            if(hasil > 0){
                JOptionPane.showMessageDialog(null, "data berhasil ditambah");
            } else {
                JOptionPane.showMessageDialog(null, "data gagal ditambah!");
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex); 
        }
    }
}
