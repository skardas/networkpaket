/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimlik;

import java.io.Serializable;

/**
 *
 * @author skardas
 */
public class Kisi implements Serializable {

    public String kullaniciAdi;
    public String parola;
    public String ad;
    public String soyadi;
    public String telefon;
    public String email;

    public Kisi(String kullaniciAdi, String parola, String ad, String soyadi, String telefon, String email) {
        this.kullaniciAdi = kullaniciAdi;
        this.parola = parola;
        this.ad = ad;
        this.soyadi = soyadi;
        this.telefon = telefon;
        this.email = email;
    }

}
