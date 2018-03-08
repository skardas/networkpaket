/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekranlar;

import com.kimlik.Kisi;
import com.komut.ArkadasEkleme;
import com.komut.KayitEkle;
import com.komut.KisiListemiGetir;
import com.komut.Mesaj;
import com.komut.OturumAcma;
import com.kullanici.KullaniciKontrol;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author skardas
 */
public class KullaniciEkran extends javax.swing.JFrame implements WindowListener {

    /**
     * Creates new form ClientFrame
     */
    public KullaniciEkran() {
        initComponents();
        addWindowListener(this);

        jPanel3.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 300, 400, 400));

        jFormattedTextField1.setText("127.0.0.1");

        jLabel1.setText("IP:");

        jLabel2.setText("Port:");

        jFormattedTextField2.setText("2020");

        jButton1.setText("Bağlan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTextField1.setText("Selam");

        jButton2.setText("Gönder");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jEditorPane1.setPreferredSize(new java.awt.Dimension(100, 300));
        jScrollPane1.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jButton3.setText("Giris");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jButton4.setText("Kayıt Ol");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jButton5.setText("Kisi Listesi İste");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);

        jButton7.setText("Arkadas Ekle");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);

        jButton8.setText("Arkadas Sil");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);

        jButton9.setText("Kisiye Baglan");
        jPanel3.add(jButton9);

        jButton6.setText("Cikis");
        jPanel3.add(jButton6);

        jScrollPane2.setViewportView(jPanel3);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    KullaniciKontrol kullaniciYonetici;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (kullaniciYonetici == null) {
            try {
                kullaniciYonetici = new KullaniciKontrol(this, jFormattedTextField1.getText(), Integer.parseInt(jFormattedTextField2.getText()));
                kullaniciYonetici.start();
                jButton1.setText("Durdur");
                jPanel3.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(KullaniciEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                jButton1.setText("Bağlan");
                ekranaMesajEkle(new Mesaj("Bağlantı:", null, "Bağlantı durduruldu"));
                kullaniciYonetici.join(100);
                jPanel3.setVisible(false);

            } catch (Exception e) {
            }
            kullaniciYonetici = null;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public void ekranaMesajEkle(Mesaj message) {
        jEditorPane1.setText(jEditorPane1.getText() + message);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (kullaniciYonetici != null && kullaniciYonetici.isAlive()) {
            try {
                kullaniciYonetici.komutuGonder(new Mesaj(kullaniciYonetici.kullaniciAdi, "sunucu", jTextField1.getText()));
                jEditorPane1.setText(jEditorPane1.getText() + "\n" + kullaniciYonetici.kullaniciAdi + ":\t" + jTextField1.getText() + "\n");
                jTextField1.setText("");
            } catch (IOException ex) {
                Logger.getLogger(KullaniciEkran.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JTextField field1 = new JTextField();
        JFormattedTextField field2 = new JFormattedTextField();
        Object[] message = {
            "Kullanici Adi:", field1,
            "Parola:", field2,};
        int option = JOptionPane.showConfirmDialog(this, message, "Kullanici Bilgilerinizi Giriniz", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String kullaniciAdi = field1.getText();
            String parola = field2.getText();
            try {
                kullaniciYonetici.komutuGonder(new OturumAcma(kullaniciAdi, parola));
            } catch (Exception e) {
                jEditorPane1.setText(jEditorPane1.getText() + "\n" + e.getMessage());
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        JTextField field1 = new JTextField();
        JFormattedTextField field2 = new JFormattedTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        JTextField field6 = new JTextField();
        JTextField field7 = new JTextField();

        Object[] message = {
            "Kullanici Adi:", field1,
            "Parola:", field2,
            "Ad:", field3,
            "Soyad:", field4,
            "Telefon:", field5,
            "Email:", field6,};
        int option = JOptionPane.showConfirmDialog(this, message, "Kullanici Bilgilerinizi Giriniz", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String kullaniciAdi = field1.getText();
            String parola = field2.getText();
            String ad = field3.getText();
            String soyad = field4.getText();
            String telefon = field5.getText();
            String email = field6.getText();
            Kisi kisi = new Kisi(kullaniciAdi, parola, ad, soyad, telefon, email);
            try {
                kullaniciYonetici.komutuGonder(new KayitEkle(kisi));
            } catch (Exception e) {
                jEditorPane1.setText(jEditorPane1.getText() + "\n" + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JTextField field1 = new JTextField();
        Object[] message = {
            "Kullanici Adi:", field1,
             };
        int option = JOptionPane.showConfirmDialog(this, message, "Eklemek İstediğiniz Arkadaşın Kullanici Adını Giriniz", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String arkadasKullaniciAdi = field1.getText();
            try 
            {
                kullaniciYonetici.komutuGonder(new ArkadasEkleme(kullaniciYonetici.kullaniciAdi,arkadasKullaniciAdi, true));
            } catch (Exception e) {
                jEditorPane1.setText(jEditorPane1.getText() + "\n" + e.getMessage());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if (kullaniciYonetici != null && kullaniciYonetici.isAlive()) {
            try {
                kullaniciYonetici.komutuGonder(new KisiListemiGetir(kullaniciYonetici.kullaniciAdi, kullaniciYonetici.kullaniciAdi));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        JTextField field1 = new JTextField();
        Object[] message = {
            "Kullanici Adi:", field1,
             };
        int option = JOptionPane.showConfirmDialog(this, message, "Silmek İstediğiniz Arkadaşın Kullanici Adını Giriniz", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String arkadasKullaniciAdi = field1.getText();
            try 
            {
                kullaniciYonetici.komutuGonder(new ArkadasEkleme(kullaniciYonetici.kullaniciAdi,arkadasKullaniciAdi, false));
            } catch (Exception e) {
                jEditorPane1.setText(jEditorPane1.getText() + "\n" + e.getMessage());
            }
        }
      
    }//GEN-LAST:event_jButton8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        dispose();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }
}
