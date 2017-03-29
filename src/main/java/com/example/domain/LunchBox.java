package com.example.domain;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017-03-27.
 */
public class LunchBox {
    private int LunchBoxID;
    private String description;
    private String ingridiences;
    private BigDecimal longitud;
    private BigDecimal latitud;
    private boolean vego;
    private boolean vegan;
    private boolean laktos;
    private boolean gluten;
    private boolean kyckling;
    private boolean fläsk;
    private boolean nöt;
    private boolean fisk;
    private byte[] image;
    private int Person_ID;

    public LunchBox() {

    }

    public LunchBox(int lunchBoxID, String description, String ingridiences, BigDecimal longitud, BigDecimal latitud, boolean vego, boolean vegan, boolean laktos, boolean gluten, boolean kyckling, boolean fläsk, boolean nöt, boolean fisk, byte[] image, int person_ID) {
        this.LunchBoxID = lunchBoxID;
        this.description = description;
        this.ingridiences = ingridiences;
        this.longitud = longitud;
        this.latitud = latitud;
        this.vego = vego;
        this.vegan = vegan;
        this.laktos = laktos;
        this.gluten = gluten;
        this.kyckling = kyckling;
        this.fläsk = fläsk;
        this.nöt = nöt;
        this.fisk = fisk;
        this.image = image;
        this.Person_ID = person_ID;
    }

    public int getLunchBoxID() {
        return LunchBoxID;
    }

    public void setLunchBoxID(int lunchBoxID) {
        LunchBoxID = lunchBoxID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngridiences() {
        return ingridiences;
    }

    public void setIngridiences(String ingridiences) {
        this.ingridiences = ingridiences;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public boolean isVego() {
        return vego;
    }

    public void setVego(boolean vego) {
        this.vego = vego;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isLaktos() {
        return laktos;
    }

    public void setLaktos(boolean laktos) {
        this.laktos = laktos;
    }

    public boolean isGluten() {
        return gluten;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

    public boolean isKyckling() {
        return kyckling;
    }

    public void setKyckling(boolean kyckling) {
        this.kyckling = kyckling;
    }

    public boolean isFläsk() {
        return fläsk;
    }

    public void setFläsk(boolean fläsk) {
        this.fläsk = fläsk;
    }

    public boolean isNöt() {
        return nöt;
    }

    public void setNöt(boolean nöt) {
        this.nöt = nöt;
    }

    public boolean isFisk() {
        return fisk;
    }

    public void setFisk(boolean fisk) {
        this.fisk = fisk;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getPerson_ID() {
        return Person_ID;
    }

    public void setPerson_ID(int person_ID) {
        Person_ID = person_ID;
    }
}

