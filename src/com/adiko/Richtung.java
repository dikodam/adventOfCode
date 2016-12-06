package com.adiko;

/**
 * Created by adiko on 06.12.2016.
 */
public enum Richtung {
    R("R"), L("L"), N("N"), S("S"), E("E"), W("W");
    String richtung;

    private Richtung(String richtung) {
        this.richtung = richtung;
    }

    public static Richtung parseMove(String drehrichtung) {
        if ("L".equals(drehrichtung)) {
            return L;
        } else if ("R".equals(drehrichtung)) {
        }
        throw new IllegalArgumentException("keine solche Drehrichtung bekannt: " + drehrichtung);
    }

    public static Richtung parseDirection(String himmelsrichtung) {
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
