/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunucu;

import com.kimlik.KimlikYonetici;
import com.komut.Dosya;
import com.komut.ElSikisma;
import com.komut.Goruntu;
import com.komut.Hamle;
import com.komut.KayitEkle;
import com.komut.OturumAcma;
import com.komut.Mesaj;
import com.komut.Ses;
import java.io.IOException;
import com.komut.KomutYorumla;

/**
 *
 * @author skard
 */
public class SunucuKomutYorumla implements KomutYorumla {

    SunucuKontrol yonetici;

    public SunucuKomutYorumla(SunucuKontrol sunucu) {
        this.yonetici = sunucu;
    }

    @Override
    public void oturumAcmaKomutuYonet(OturumAcma oturumAcma) {
        System.out.println("oturumAcmaKomutuYonet:");
        OturumAcma cvp = new OturumAcma(null, null);
        if (KimlikYonetici.getInstance().isDogrula(oturumAcma.kullaniciAdi, oturumAcma.parola)) {
            yonetici.kullaniciEkle(oturumAcma);
            cvp.kullaniciAdi = oturumAcma.kullaniciAdi;
            cvp.isBasarili = true;
            yonetici.komutuBanaGonder(cvp);

        } else {
            cvp.isBasarili = false;
            cvp.cevap = "Kullanıcı adı ve/veya parolayı hatalıdır";
            yonetici.komutuBekleyenListedenBanaGonder(cvp);

        }
        yonetici.ekranaMesajEkle(cvp.isBasarili ? oturumAcma.kullaniciAdi + " doğrulandı." : "Kullanıcı adı ve/veya parola hatalı girişim!");

    }

    @Override
    public void sesKomutuYonet(Ses ses) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goruntuKomutuYonet(Goruntu goruntu) {

    }

    @Override
    public void mesajKomutuYonet(Mesaj mesaj) {
        try {
            yonetici.komutuBenHaricHerkeseGonder(mesaj);
            yonetici.sunucuEkran.ekranaMesajEkle(mesaj.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void hamleKomutuYonet(Hamle hamle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dosyaKomutuYonet(Dosya dosya) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elsikismaKomutuYonet(ElSikisma elSikisma) {

    }

    @Override
    public void kisiEkleYonet(KayitEkle kayit) {
    }

}
