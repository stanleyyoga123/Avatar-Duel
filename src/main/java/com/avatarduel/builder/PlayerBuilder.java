package com.avatarduel.builder;

import com.avatarduel.model.Card;
import com.avatarduel.model.Player;

import java.util.ArrayList;
import java.util.Stack;

public class PlayerBuilder {
    private int player;
    private ArrayList<Card> handDeck;
    private ArrayList<Card> midTopDeck;
    private ArrayList<Card> midBotDeck;
    private Stack<Card> drawDeck;
    private int health;
    private int airPower;
    private int waterPower;
    private int earthPower;
    private int firePower;
    private boolean isPlayedLand;
    private int remainingAir;
    private int remainingWater;
    private int remainingEarth;
    private int remainingFire;

    public Player build(){
        Player a = new Player();
        a.setPlayer(player);
        a.setAirPower(airPower);
        a.setWaterPower(waterPower);
        a.setFirePower(firePower);
        a.setEarthPower(earthPower);
        a.setRemainingAir(remainingAir);
        a.setRemainingEarth(remainingEarth);
        a.setRemainingFire(remainingFire);
        a.setRemainingWater(remainingWater);
        a.setDrawDeck(drawDeck);
        a.setMidBotDeck(midBotDeck);
        a.setMidTopDeck(midTopDeck);
        a.setHealth(health);
        a.setHandDeck(handDeck);
        a.setIsPlayedLand(isPlayedLand);
        return a;
    }

    public PlayerBuilder player(int player) {
        this.player = player;
        return this;
    }

    public PlayerBuilder handDeck(ArrayList<Card> handDeck) {
        this.handDeck = handDeck;
        return this;
    }

    public PlayerBuilder midTopDeck(ArrayList<Card> midTopDeck) {
        this.midTopDeck = midTopDeck;
        return this;
    }

    public PlayerBuilder midBotDeck(ArrayList<Card> midBotDeck) {
        this.midBotDeck = midBotDeck;
        return this;
    }

    public PlayerBuilder drawDeck(Stack<Card> drawDeck) {
        this.drawDeck = drawDeck;
        return this;
    }

    public PlayerBuilder health(int health) {
        this.health = health;
        return this;
    }

    public PlayerBuilder airPower(int airPower) {
        this.airPower = airPower;
        return this;
    }

    public PlayerBuilder waterPower(int waterPower) {
        this.waterPower = waterPower;
        return this;
    }

    public PlayerBuilder earthPower(int earthPower) {
        this.earthPower = earthPower;
        return this;
    }

    public PlayerBuilder firePower(int firePower) {
        this.firePower = firePower;
        return this;
    }

    public PlayerBuilder isPlayedLand(boolean playedLand) {
        this.isPlayedLand = playedLand;
        return this;
    }

    public PlayerBuilder remainingAir(int remainingAir) {
        this.remainingAir = remainingAir;
        return this;
    }

    public PlayerBuilder remainingWater(int remainingWater) {
        this.remainingWater = remainingWater;
        return this;
    }

    public PlayerBuilder remainingEarth(int remainingEarth) {
        this.remainingEarth = remainingEarth;
        return this;
    }

    public PlayerBuilder remainingFire(int remainingFire) {
        this.remainingFire = remainingFire;
        return this;
    }
}
