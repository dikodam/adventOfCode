package com.adiko;

/**
 * Created by adiko on 06.12.2016.
 */
public class Befehl {
    private Drehrichtung drehrichtung;
    private int schritte;

    public Befehl(Drehrichtung drehrichtung, int schritte) {
        this.drehrichtung = drehrichtung;
        this.schritte = schritte;
    }

    public int getSchritte() {
        return schritte;
    }

    public Drehrichtung getDrehrichtung() {
        return drehrichtung;
    }
}
