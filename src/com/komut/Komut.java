/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komut;

import com.kullanici.KullaniciKomutYorumla;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author skard
 */
public abstract class Komut implements Serializable {

    public String seriNo = null;
    public String kimden;
    public String kime;
    public Date zaman;
    public boolean isBasarili = false;
    public String cevap = null;
    
    public Komut(String kimden, String kime) {
        this.kimden = kimden;
        this.kime = kime;
        zaman = new Date();
        this.seriNo = KullaniciKomutYorumla.SeriNo;
    }

    public abstract void calistir(KomutYorumla kmt);
}
