/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kendaraan;

import database.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author h
 */
public class Motor extends Kendaraan{

    private final String tipe = "1";
    private String merek;
    private String model;
    private String tahunProduksi;
    private String platNomor;
    private int hargaSewa;
    private int status;
    private String gambar;
    private int hasil;
    
    
    //------------------ constructor
    public Motor(String merek, String model, String tahunProduksi, String platNomor, int hargaSewa, String gambar){
        this.merek = merek;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
        this.platNomor = platNomor;
        this.hargaSewa = hargaSewa;
        this.gambar = gambar;
    }
    public Motor(){
        
    }
    
    
    
    @Override
    public int tambahKendaraan(){
        String[] namaKolom = {"tipe", "merek", "model", "tahun_produksi", "plat_nomor", "harga_sewa", "gambar"};
        String[] isiKolom = {this.tipe, this.merek, this.model, this.tahunProduksi, this.platNomor, Integer.toString(this.hargaSewa), this.gambar};
        try {
            hasil = QueryDatabase.queryMasukan("kendaraan", namaKolom, isiKolom, this.gambar);
        } catch(SQLException | IOException ex){
             JOptionPane.showMessageDialog(null, ex);
        }
        KoneksiDatabase.tutupKoneksi();
        return hasil;
    }

    @Override
    public int ubahKendaraan(String kondisi) {       
        String[] namaKolom = {"tipe", "merek", "model", "tahun_produksi", "plat_nomor", "harga_sewa", "gambar"};
        String[] isiKolom = {this.tipe, this.merek, this.model, this.tahunProduksi, this.platNomor, Integer.toString(this.hargaSewa), this.gambar};
        try{
            hasil = QueryDatabase.queryUpdate("kendaraan", namaKolom, isiKolom, kondisi);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        KoneksiDatabase.tutupKoneksi();
        return hasil;
    }

    @Override
    public int hapusKendaraan(String kondisi) {
        try{
            hasil = QueryDatabase.queryHapus("kendaraan", kondisi);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        KoneksiDatabase.tutupKoneksi();
        return hasil;
    }
  
}
