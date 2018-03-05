/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komut;

import java.io.Serializable;

/**
 *
 * @author skard
 */
public interface KomutYorumla extends Serializable {

    public void oturumAcmaKomutuYonet(OturumAcma login);

    public void sesKomutuYonet(Ses ses);

    public void goruntuKomutuYonet(Goruntu goruntu);

    public void dosyaKomutuYonet(Dosya dosya);

    public void mesajKomutuYonet(Mesaj mesaj);

    public void hamleKomutuYonet(Hamle hamle);

    public void elsikismaKomutuYonet(ElSikisma elSikisma);

}
