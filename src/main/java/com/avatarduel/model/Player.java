package com.avatarduel.model;

import com.avatarduel.model.attribute.Deck;
import com.avatarduel.model.attribute.MidDeck;
import com.avatarduel.model.attribute.Power;
import com.avatarduel.model.attribute.RemainingPower;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> handDeck;
    private int health;
    private boolean isPlayedLand;
    private MidDeck midDeck;
    private Deck drawDeck;
    private Power power;
    private RemainingPower remPower;

    public Player(ArrayList<Card> handDeck, int health, boolean isPlayedLand, MidDeck midDeck, Deck drawDeck, Power power, RemainingPower remPower) {
        this.handDeck = handDeck;
        this.health = health;
        this.isPlayedLand = isPlayedLand;
        this.midDeck = midDeck;
        this.drawDeck = drawDeck;
        this.power = power;
        this.remPower = remPower;
    }

    public ArrayList<Card> getHandDeck() {
        return handDeck;
    }

    public void setHandDeck(ArrayList<Card> handDeck) {
        this.handDeck = handDeck;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isPlayedLand() {
        return isPlayedLand;
    }

    public void setPlayedLand(boolean playedLand) {
        isPlayedLand = playedLand;
    }

    public MidDeck getMidDeck() {
        return midDeck;
    }

    public void setMidDeck(MidDeck midDeck) {
        this.midDeck = midDeck;
    }

    public Deck getDrawDeck() {
        return drawDeck;
    }

    public void setDrawDeck(Deck drawDeck) {
        this.drawDeck = drawDeck;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public RemainingPower getRemPower() {
        return remPower;
    }

    public void setRemPower(RemainingPower remPower) {
        this.remPower = remPower;
    }
}

