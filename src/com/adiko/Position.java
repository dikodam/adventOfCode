package com.adiko;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Position {

    private int x;
    private int y;
    private CardinalDirection cardinalDirection;
    private static Position instance;
    private Integer x2;
    private Integer y2;
    private Set<Pair<Integer, Integer>> positionsVisited;
    private Pair<Integer, Integer> firstPositionVisitedTwice;


    private Position() {
        x = 0;
        y = 0;
        cardinalDirection = CardinalDirection.N;
        positionsVisited = new HashSet<>();
        positionsVisited.add(new Pair(x, y));
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
        for (int i = 0; i < steps; i++) {
            switch (cardinalDirection) {
                case N:
                    y++;
                    break;
                case E:
                    x++;
                    break;
                case S:
                    y--;
                    break;
                case W:
                    x--;
                    break;
            }
            Pair<Integer, Integer> newPosition = new Pair<>(x, y);
            if (!hasDoubleVisitedPositions() && !positionsVisited.add(newPosition)) {
                firstPositionVisitedTwice = newPosition;
            }
        }
    }

    public int getDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    public Pair<Integer, Integer> getFirstPositionVisitedTwice() {
        if (hasDoubleVisitedPositions()) {
            return firstPositionVisitedTwice;
        } else {
            throw new IllegalStateException("keine doppelte Position vorhanden!");
        }
    }

    public boolean hasDoubleVisitedPositions() {
        return firstPositionVisitedTwice != null;
    }
}
