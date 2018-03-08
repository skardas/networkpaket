/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunucu;

import com.ekranlar.SunucuEkran;
import com.kimlik.KimlikYonetici;
import com.komut.ElSikisma;
import com.komut.Komut;
import com.komut.OturumAcma;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.komut.KomutYorumla;
import com.komut.KullaniciKayitEkle;

/**
 *
 * @author skardas
 */
public class SunucuKontrol extends Thread {

    boolean isDurduruldu = false;
    KomutYorumla yorumlayici;
    int sunucuPort;
    protected ServerSocket serverSocket = null;
    protected ExecutorService threadHavuzu = Executors.newFixedThreadPool(10);
    SunucuEkran sunucuEkran;
    HashMap<String, Kullanici> dogrulananKullanicilar = new HashMap<>();
    HashMap<String, Kullanici> bekleyenKullanicilar = new HashMap<>();

    public SunucuKontrol(SunucuEkran sunucuEkran, int sunucuPort) {
        this.sunucuEkran = sunucuEkran;
        this.sunucuPort = sunucuPort;
        yorumlayici = new SunucuKomutYorumla(this);
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(sunucuPort);
            ekranaMesajEkle("Sunucu dinlemeye başladı...");
        } catch (Exception e) {
            ekranaMesajEkle(e.getMessage());
            isDurduruldu = true;
        }
        while (!isStopped()) {
            try {
                Socket socket = serverSocket.accept();
                ObjectOutputStream cikis = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream giris = new ObjectInputStream(socket.getInputStream());

                ElSikisma elSikisma = new ElSikisma("" + Math.random());
                cikis.writeObject(elSikisma);
                cikis.flush();

                Kullanici kullanici = new Kullanici(cikis, giris);
                bekleyenKullanicilar.put(elSikisma.seriNo, kullanici);
                this.threadHavuzu.execute(kullanici);
            } catch (Exception e) {
                ekranaMesajEkle(e.getMessage());
            }
        }
        this.threadHavuzu.shutdown();
        ekranaMesajEkle("Sunucu durduruldu.");
    }

    public synchronized void ekranaMesajEkle(String mesaj) {
        sunucuEkran.ekranaMesajEkle(mesaj);
    }

    private synchronized boolean isStopped() {
        return this.isDurduruldu;
    }

    public void stopServer() {
        this.isDurduruldu = true;
        try {
            threadHavuzu.shutdownNow();
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    public synchronized void komutuHerkeseGonder(Komut komut) throws IOException {
        for (Iterator<Kullanici> it = dogrulananKullanicilar.values().iterator(); it.hasNext();) {
            Kullanici client = it.next();
            client.komutuGonder(komut);
        }
    }

    synchronized void komutuBenHaricHerkeseGonder(Komut komut) throws IOException {
        for (Iterator<Kullanici> it = dogrulananKullanicilar.values().iterator(); it.hasNext();) {
            Kullanici client = it.next();
            if (!client.kullaniciAdi.equalsIgnoreCase(komut.kimden)) {
                client.komutuGonder(komut);
            }
        }
    }

    public synchronized void komutuBanaGonder(Komut cvp) {
        Kullanici kullanici = dogrulananKullanicilar.get(cvp.kimden);
        try {
            kullanici.komutuGonder(cvp);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void kullaniciCevrimiciListeyeEkle(String seriNo, String kullaniciAdi) {
        Kullanici kullanici = bekleyenKullanicilar.remove(seriNo);
        kullanici.kullaniciAdi = kullaniciAdi;
        dogrulananKullanicilar.put(kullaniciAdi, kullanici);
        KimlikYonetici.getInstance().setCevrimici(kullaniciAdi,true);
    }
    public synchronized void kullaniciCevrimiciListedenCikar(String kullaniciAdi) {
        Kullanici kullanici = dogrulananKullanicilar.remove(kullaniciAdi);
        try 
        {
            kullanici.close();
            KimlikYonetici.getInstance().setCevrimici(kullaniciAdi,false);
        } catch (Exception e) {
        }
    }

    void komutuBekleyenListedenBanaGonder(Komut cvp) {
        Kullanici kullanici = bekleyenKullanicilar.get(cvp.seriNo);
        try {
            kullanici.komutuGonder(cvp);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private class Kullanici implements Runnable {

        boolean isClosed = false;
        ObjectOutputStream cikis;
        ObjectInputStream giris;
        String kullaniciAdi;
        public boolean isDurduruldu = false;
        public Kullanici(ObjectOutputStream cikis, ObjectInputStream giris) throws IOException {
            this.giris = giris;
            this.cikis = cikis;
        }

        @Override
        public void run() {
            Komut komut;
            try {
                while ((komut = (Komut)giris.readObject()) != null && !isDurduruldu) {
                    if((komut instanceof ElSikisma || komut instanceof OturumAcma || komut instanceof KullaniciKayitEkle)
                            || KimlikYonetici.getInstance().isCevrimici(komut.kimden))
                    {
                        komut.calistir(yorumlayici);
                    }

                }
            } catch (Exception e) {
               // e.printStackTrace();
            }
        }

        public void close() {
            try {
                isDurduruldu = true;
                giris.close();
                cikis.close();
                
            } catch (Exception e) {
            }
        }

        public void komutuGonder(Komut komut) throws IOException {
            cikis.writeObject(komut);
            cikis.flush();
        }

    }

}
