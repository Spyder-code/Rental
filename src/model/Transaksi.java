/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.*;
import javax.swing.JOptionPane;
/**
 *
 * @author h
 */
public class Transaksi {
    
  
    private int hasil;
    
    
    public Transaksi(){
        
    }
    
    public int ubahTransaksi(String totalBiaya, String status, String kondisi){
        String[] namaKolom = {"total_biaya", "status_pembayaran"};
        String[] isiKolom = {totalBiaya, status};
        try {
            hasil = QueryDatabase.queryUpdate("detail_peminjaman", namaKolom, isiKolom, kondisi);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        KoneksiDatabase.tutupKoneksi();
        return hasil;
    }
    
}
