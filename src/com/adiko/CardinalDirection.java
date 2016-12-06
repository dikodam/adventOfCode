package com.adiko;

public enum CardinalDirection {
    N("N"), S("S"), E("E"), W("W");
    private String direction;

    CardinalDirection(String direction) {
        this.direction = direction;
    }


    public static CardinalDirection parseDirection(String cardinalDirection) {
        if ("N".equals(cardinalDirection)) {
            return N;
        } else if ("S".equals(cardinalDirection)) {
            return S;
        } else if ("W".equals(cardinalDirection)) {
            return W;
        } else if ("E".equals(cardinalDirection)) {
            return E;
        }
        throw new IllegalArgumentException("kein solche Himmelsrichtung bekannt: " + cardinalDirection);
    }

    public CardinalDirection turn(Turndirection turndirection) {
        if (turndirection == Turndirection.R) {
            // clockwise
            switch (direction) {
                case "N":
                    return CardinalDirection.E;
                case "E":
                    return CardinalDirection.S;
                case "S":
                    return CardinalDirection.W;
                case "W":
                    return CardinalDirection.N;
                default:
                    return this;
            }
        } else {
            // anticlockwise
            switch (direction) {
                case "N":
                    return CardinalDirection.W;
                case "W":
                    return CardinalDirection.S;
                case "S":
                    return CardinalDirection.E;
                case "E":
                    return CardinalDirection.N;
                default:
                    return this;
            }
        }
    }
}
