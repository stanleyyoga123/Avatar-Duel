package com.avatarduel.games;

abstract public class GameState {
    private GameFlow gameFlow;

    public abstract void start();
    public abstract void end();
}
