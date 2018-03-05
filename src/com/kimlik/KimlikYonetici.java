/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimlik;

/**
 *
 * @author skardas
 */
public class KimlikYonetici {

    private static KimlikYonetici kimlikYonetici;

    public static KimlikYonetici getInstance() {
        if (kimlikYonetici == null) {
            kimlikYonetici = new KimlikYonetici();
        }
        return kimlikYonetici;
    }

    private KimlikYonetici() {

    }

    public boolean isDogrula(String kullaniciAdi, String parola) {

        return true;
    }

}
