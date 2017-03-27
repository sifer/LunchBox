package com.example.domain;

/**
 * Created by Administrator on 2017-03-27.
 */
public class LunchBox {
    public final String description;
    public final String ingridiences;
    public final String longitud;
    public final String latitud;
    public final String vego;
    public final String vegan;
    public final String kyckling;
    public final String fläsk;
    public final String nöt;
    public final String fisk;
    public final String image;

    public LunchBox(String description, String ingridiences, String longitud, String latitud, String vego, String vegan, String kyckling, String fläsk, String nöt, String fisk, String image) {
        this.description = description;
        this.ingridiences = ingridiences;
        this.longitud = longitud;
        this.latitud = latitud;
        this.vego = vego;
        this.vegan = vegan;
        this.kyckling = kyckling;
        this.fläsk = fläsk;
        this.nöt = nöt;
        this.fisk = fisk;
        this.image = image;
    }
}





