/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komut;

/**
 *
 * @author skardas
 */
public class ElSikisma extends Komut{

    public ElSikisma(String seriNo) {
        super(null, null);
        this.seriNo = seriNo;
    }

    @Override
    public void calistir(KomutYorumla kmt) {
        kmt.elsikismaKomutuYonet(this);
    }
    
}
