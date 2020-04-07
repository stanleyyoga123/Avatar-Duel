package com.avatarduel.model;

import com.avatarduel.model.Card;

import java.util.ArrayList;
import java.util.Stack;

public class Player {
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

    public Player(){}

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public ArrayList<Card> getHandDeck() {
        return handDeck;
    }

    public void setHandDeck(ArrayList<Card> handDeck) {
        this.handDeck = handDeck;
    }

    public ArrayList<Card> getMidTopDeck() {
        return midTopDeck;
    }

    public void setMidTopDeck(ArrayList<Card> midTopDeck) {
        this.midTopDeck = midTopDeck;
    }

    public ArrayList<Card> getMidBotDeck() {
        return midBotDeck;
    }

    public void setMidBotDeck(ArrayList<Card> midBotDeck) {
        this.midBotDeck = midBotDeck;
    }

    public Stack<Card> getDrawDeck() {
        return drawDeck;
    }

    public void setDrawDeck(Stack<Card> drawDeck) {
        this.drawDeck = drawDeck;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAirPower() {
        return airPower;
    }

    public void setAirPower(int airPower) {
        this.airPower = airPower;
    }

    public int getWaterPower() {
        return waterPower;
    }

    public void setWaterPower(int waterPower) {
        this.waterPower = waterPower;
    }

    public int getEarthPower() {
        return earthPower;
    }

    public void setEarthPower(int earthPower) {
        this.earthPower = earthPower;
    }

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    public boolean isPlayedLand() {
        return isPlayedLand;
    }

    public void setPlayedLand(boolean playedLand) {
        isPlayedLand = playedLand;
    }

    public int getRemainingAir() {
        return remainingAir;
    }

    public void setRemainingAir(int remainingAir) {
        this.remainingAir = remainingAir;
    }

    public int getRemainingWater() {
        return remainingWater;
    }

    public void setRemainingWater(int remainingWater) {
        this.remainingWater = remainingWater;
    }

    public int getRemainingEarth() {
        return remainingEarth;
    }

    public void setRemainingEarth(int remainingEarth) {
        this.remainingEarth = remainingEarth;
    }

    public int getRemainingFire() {
        return remainingFire;
    }

    public void setRemainingFire(int remainingFire) {
        this.remainingFire = remainingFire;
    }

    public void setIsPlayedLand(boolean isPlayedLand) {
    }
}

