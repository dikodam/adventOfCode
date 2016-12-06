package com.adiko;

/**
 * Created by Adam on 06.12.2016.
 */
public enum Drehrichtung {
    R("R"), L("L");
    String drehrichtung;

    Drehrichtung(String drehrichtung) {
        this.drehrichtung = drehrichtung;
    }


    public static Drehrichtung parseMove(String drehrichtung) {
        if ("L".equals(drehrichtung)) {
            return L;
        } else if ("R".equals(drehrichtung)) {
            return R;
        }
        throw new IllegalArgumentException("keine solche Drehrichtung bekannt: " + drehrichtung);
    }
}
