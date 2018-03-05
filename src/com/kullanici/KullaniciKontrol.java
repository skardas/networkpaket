/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kullanici;

import com.ekranlar.KullaniciEkran;
import com.komut.Komut;
import com.komut.Mesaj;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.komut.KomutYorumla;

/**
 *
 * @author skardas
 */
public class KullaniciKontrol extends Thread {

    String sunucuIP;
    int sunucuPort;
    ObjectOutputStream cikis;
    ObjectInputStream giris;
    boolean isDurduruldu = false;
    KullaniciEkran ekran;
    public String kullaniciAdi;

    KomutYorumla yorumlayici;

    public KullaniciKontrol(KullaniciEkran frame, String sunucuIP, int sunucuPort) throws IOException {
        this.ekran = frame;
        this.sunucuIP = sunucuIP;
        this.sunucuPort = sunucuPort;
        yorumlayici = new KullaniciKomutYorumla(this);
        Socket socket = new Socket(sunucuIP, sunucuPort);
        this.cikis
                = new ObjectOutputStream(socket.getOutputStream());
        this.giris = new ObjectInputStream(socket.getInputStream());
        frame.ekranaMesajEkle(new Mesaj("Bağlantı", null, "Sunucuya bağlanıldı"));
    }

    @Override
    public void run() {
        //Sunucudan gelen komut nesneleri dinler
        Komut komut;
        try {
            while (!isDurduruldu) {
                komut = (Komut) giris.readObject();
                komut.calistir(yorumlayici);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void komutuGonder(Komut komut) throws IOException {
        cikis.writeObject(komut);
        cikis.flush();
    }

}
