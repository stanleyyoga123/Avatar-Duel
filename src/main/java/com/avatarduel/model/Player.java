package com.avatarduel.model;

import com.avatarduel.model.attribute.Deck;
import com.avatarduel.model.attribute.MidDeck;
import com.avatarduel.model.attribute.Power;
import com.avatarduel.model.attribute.RemainingPower;

import java.util.ArrayList;

/**
 * Class for Player
 */

public class Player {
    private ArrayList<Card> handDeck;
    private int health;
    private boolean isPlayedLand;
    private MidDeck midDeck;
    private Deck drawDeck;
    private Power power;
    private RemainingPower remPower;

    /**
     * Constructor Player
     * @param handDeck Hand Deck
     * @param health Heatlh
     * @param isPlayedLand Is Played Land
     * @param midDeck Mid Deck
     * @param drawDeck Draw Deck
     * @param power Power
     * @param remPower Remaining Power
     */
    public Player(ArrayList<Card> handDeck, int health, boolean isPlayedLand, MidDeck midDeck, Deck drawDeck, Power power, RemainingPower remPower) {
        this.handDeck = handDeck;
        this.health = health;
        this.isPlayedLand = isPlayedLand;
        this.midDeck = midDeck;
        this.drawDeck = drawDeck;
        this.power = power;
        this.remPower = remPower;
    }

    /**
     * Hand Deck Getter
     * @return List of Card
     */
    public ArrayList<Card> getHandDeck() {
        return handDeck;
    }

    /**
     * Health Getter
     * @return Health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Health Setter
     * @param health Health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Getter isPlayedPland
     * @return is played land
     */
    public boolean isPlayedLand() {
        return isPlayedLand;
    }

    /**
     * Player Land Setter
     * @param playedLand true if played land
     */
    public void setPlayedLand(boolean playedLand) {
        isPlayedLand = playedLand;
    }

    /**
     * Mid Deck Getter
     * @return Mid Deck
     */
    public MidDeck getMidDeck() {
        return midDeck;
    }

    /**
     * Draw Deck Getter
     * @return Mid Deck
     */
    public Deck getDrawDeck() {
        return drawDeck;
    }

    /**
     * Power Getter
     * @return Power
     */
    public Power getPower() {
        return power;
    }

    /**
     * Power Setter
     * @param power Power
     */
    public void setPower(Power power) {
        this.power = power;
    }

    /**
     * Remaining Power Getter
     * @return Remaining Power
     */
    public RemainingPower getRemPower() {
        return remPower;
    }
}

