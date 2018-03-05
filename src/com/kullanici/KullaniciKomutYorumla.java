/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kullanici;

import com.komut.Dosya;
import com.komut.ElSikisma;
import com.komut.Goruntu;
import com.komut.Hamle;
import com.komut.KayitEkle;
import com.komut.KomutYorumla;
import com.komut.Mesaj;
import com.komut.OturumAcma;
import com.komut.Ses;

/**
 *
 * @author skard
 */
public class KullaniciKomutYorumla implements KomutYorumla {

    public static String SeriNo = null;
    KullaniciKontrol yonetici;

    public KullaniciKomutYorumla(KullaniciKontrol yonetici) {
        this.yonetici = yonetici;
    }

    @Override
    public void oturumAcmaKomutuYonet(OturumAcma login) {
        if (login.isBasarili) {
            yonetici.ekran.ekranaMesajEkle(new Mesaj("Sunucu", null, "Oturumu başarılı bir şekilde açtınız."));
            yonetici.kullaniciAdi = login.kullaniciAdi;
        } else {
            yonetici.ekran.ekranaMesajEkle(new Mesaj("Sunucu", null, login.cevap));
        }
    }

    @Override
    public void sesKomutuYonet(Ses ses) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goruntuKomutuYonet(Goruntu goruntu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mesajKomutuYonet(Mesaj mesaj) {
        yonetici.ekran.ekranaMesajEkle(mesaj);
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
        KullaniciKomutYorumla.SeriNo = elSikisma.seriNo;
    }

    @Override
    public void kisiEkleYonet(KayitEkle kayit) {

    }

}
