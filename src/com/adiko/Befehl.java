package com.adiko;

/**
 * Created by adiko on 06.12.2016.
 */
public class Befehl {
    Richtung richtung;
    int schritte;

    public Befehl(Richtung richtung, int schritte) {
        this.richtung = richtung;
        this.schritte = schritte;
    }
}
