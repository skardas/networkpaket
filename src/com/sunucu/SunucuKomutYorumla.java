/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunucu;

import com.kimlik.KimlikYonetici;
import com.kimlik.Kisi;
import com.komut.ArkadasEkleme;
import com.komut.Dosya;
import com.komut.ElSikisma;
import com.komut.Goruntu;
import com.komut.Hamle;
import com.komut.KayitEkle;
import com.komut.KisiListemiGetir;
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
    public void oturumAcmaKomutuYonet(OturumAcma oturumAcma) 
    {
        OturumAcma cvp = new OturumAcma(null, null);
        if (KimlikYonetici.getInstance().isDogrula(oturumAcma.kullaniciAdi, oturumAcma.parola)) {
            yonetici.kullaniciCevrimiciListeyeEkle(oturumAcma.seriNo, oturumAcma.kullaniciAdi);
            cvp.kullaniciAdi = oturumAcma.kullaniciAdi;
            cvp.kimden = oturumAcma.kullaniciAdi;
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
     }

    @Override
    public void dosyaKomutuYonet(Dosya dosya) {
     }

    @Override
    public void elsikismaKomutuYonet(ElSikisma elSikisma) {

    }

    @Override
    public void kisiEkleYonet(KayitEkle kayit) {
        KayitEkle cevap = new KayitEkle(kayit.kisi);
        KimlikYonetici ky = KimlikYonetici.getInstance();
        if (!ky.isKisiVar(kayit.kisi.kullaniciAdi)) 
        {
            ky.kisiEkle(kayit.kisi);
            cevap.isBasarili = true;
            cevap.kimden = kayit.kisi.kullaniciAdi;
            yonetici.kullaniciCevrimiciListeyeEkle(kayit.seriNo ,kayit.kisi.kullaniciAdi);
            yonetici.komutuBanaGonder(cevap);
        } 
        else 
        {
            cevap.isBasarili = false;
            cevap.cevap = "Böyle bir kullanıcı zaten kullanılmaktadır.";
            yonetici.komutuBekleyenListedenBanaGonder(cevap);
        }
    }

    @Override
    public void kisiListemiGetirYonet(KisiListemiGetir klg) {
        Kisi kisi = KimlikYonetici.getInstance().kisiGetir(klg.kimden);
        KisiListemiGetir cvp = new KisiListemiGetir(klg.kimden, klg.kime);
        cvp.kisilerim.addAll(kisi.arkadaslar);
        yonetici.komutuBanaGonder(cvp);
    }

    @Override
    public void arkadasEklemeYonet(ArkadasEkleme ae) 
    {
       String sonuc  = KimlikYonetici.getInstance().arkadasEkleme(ae);

       ArkadasEkleme cvp = new ArkadasEkleme(ae.kimden, ae.islemYapilacakKullaniciAdi, ae.isEklenecek);
       cvp.isBasarili = (sonuc == null);
       cvp.cevap = sonuc;
       
       yonetici.komutuBanaGonder(cvp);
         
    }

}
