package com.example.omerveberna.pastam;

/**
 * Created by omerveberna on 11.03.2018.
 */

public class Pastalar {
    private String icerik;
    private String kisiSayisi;
    private String fiyat;


    public Pastalar(){
    }

    public Pastalar(String icerik, String kisiSayisi, String fiyat) {
        this.icerik = icerik;
        this.kisiSayisi = kisiSayisi;
        this.fiyat = fiyat;

    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getKisiSayisi() {
        return kisiSayisi;
    }

    public void setKisiSayisi(String weight) {
        this.kisiSayisi = weight;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String name) {
        this.fiyat = name;
    }


}