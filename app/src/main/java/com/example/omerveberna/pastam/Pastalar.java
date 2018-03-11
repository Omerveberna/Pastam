package com.example.omerveberna.pastam;

/**
 * Created by omerveberna on 11.03.2018.
 */

public class Pastalar {
    private String icerik;
    private String kisi;
    private String fiyat;


    public Pastalar(){
    }

    public Pastalar(String icerik, String kisi, String fiyat) {
        this.icerik = icerik;
        this.kisi = kisi;
        this.fiyat = fiyat;

    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getkisi() {
        return kisi;
    }

    public void setkisi(String weight) {
        this.kisi = weight;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String name) {
        this.fiyat = name;
    }


}