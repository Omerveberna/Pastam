package com.example.omerveberna.pastam;

/**
 * Created by omerveberna on 11.03.2018.
 */

public class Siparisler {


    private String uid;
    private String icerik;
    private String kisi;
    private String fiyat;


    public Siparisler(String icerik, String kisi, String fiyat, String email) {
        this.icerik = icerik;
        this.kisi = kisi;
        this.fiyat = fiyat;
        this.uid = uid;

    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getKisi() {
        return kisi;
    }

    public void setKisi(String weight) {
        this.kisi = weight;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String name) {
        this.fiyat = name;
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public Siparisler(){
    }


}