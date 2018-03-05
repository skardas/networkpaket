/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komut;

import com.kimlik.Kisi;

/**
 *
 * @author skardas
 */
public class KayitEkle extends Komut {

    public Kisi kisi;

    public KayitEkle(Kisi kisi) {
        super(null, null);
        this.kisi = kisi;
    }

    @Override
    public void calistir(KomutYorumla kmt) {
        kmt.kisiEkleYonet(this);
    }

}
