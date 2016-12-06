package com.adiko;

public enum Turndirection {
    R("R"), L("L");
    private String turndirection;

    Turndirection(String turndirection) {
        this.turndirection = turndirection;
    }


    public static Turndirection parseMove(String turndirection) {
        if ("L".equals(turndirection)) {
            return L;
        } else if ("R".equals(turndirection)) {
            return R;
        }
        throw new IllegalArgumentException("keine solche Drehrichtung bekannt: " + turndirection);
    }
}
