/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author h
 */
public class Gambar {
    private static String namaGambar;

    
    public static String getNamaGambar() {
        return namaGambar; 
    }
    public static void setNamaGambar(String namaFile) {
        namaGambar = namaFile;
    }
    public static void kosongkanGambar(){
        namaGambar = "";
    }
}
