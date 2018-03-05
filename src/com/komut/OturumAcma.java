/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komut;

/**
 *
 * @author skard
 */
public class OturumAcma extends Komut {

    public String kullaniciAdi;
    public String parola;
    public OturumAcma(String kullaniciAdi, String parola) {
        super(null, null);
        this.kullaniciAdi = kullaniciAdi;
        this.parola = parola;
    }

    @Override
    public void calistir(KomutYorumla kmt) {
        kmt.oturumAcmaKomutuYonet(this);
    }
}
