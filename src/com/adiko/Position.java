package com.adiko;

public class Position {

    private int x;
    private int y;
    private CardinalDirection cardinalDirection;
    private static Position instance;

    private Position() {
        x = 0;
        y = 0;
        cardinalDirection = CardinalDirection.N;
    }

    public static Position getInstance() {
        if (instance == null) {
            instance = new Position();
        }
        return instance;
    }


    public void execute(Command command) {
        cardinalDirection = cardinalDirection.turn(command.getTurndirection());
        int steps = command.getSteps();
        // move accordingly to cd
        switch (cardinalDirection) {
            case N:
                y += steps;
                break;
            case E:
                x += steps;
                break;
            case S:
                y -= steps;
                break;
            case W:
                x -= steps;
                break;
        }
    }

    public int getDistance() {
        return Math.abs(x) + Math.abs(y);
    }
}
