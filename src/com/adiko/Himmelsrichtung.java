package com.adiko;

/**
 * Created by adiko on 06.12.2016.
 */
public enum Himmelsrichtung {
    N("N"), S("S"), E("E"), W("W");
    String richtung;

    Himmelsrichtung(String richtung) {
        this.richtung = richtung;
    }


    public static Himmelsrichtung parseDirection(String himmelsrichtung) {
        if("N".equals(himmelsrichtung)){
            return N;
        }else if("S".equals(himmelsrichtung)){
            return S;
        }else if("W".equals(himmelsrichtung)){
            return W;
        }else if("E".equals(himmelsrichtung)){
            return E;
        }
        throw new IllegalArgumentException("kein solche Himmelsrichtung bekannt: " + himmelsrichtung);
    }
}
