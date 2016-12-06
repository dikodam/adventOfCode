package com.adiko;

public class Command {
    private Turndirection turndirection;
    private int steps;

    public Command(Turndirection turndirection, int steps) {
        this.turndirection = turndirection;
        this.steps = steps;
    }

    public int getSteps() {
        return steps;
    }

    public Turndirection getTurndirection() {
        return turndirection;
    }
}
