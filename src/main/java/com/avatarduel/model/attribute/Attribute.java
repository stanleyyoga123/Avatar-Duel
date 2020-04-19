package com.avatarduel.model.attribute;

/**
 * Class contains Attribute
 */

public class Attribute {
    private int attack;
    private int defense;
    private int power;

    /**
     * Attribute Constructor
     * @param attack Attack
     * @param defense Defense
     * @param power Power
     */
    public Attribute(int attack, int defense, int power) {
        this.attack = attack;
        this.defense = defense;
        this.power = power;
    }

    /**
     * Getter Attack
     * @return Attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Setter Attack
     * @param attack Attack
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Getter Defense
     * @return Defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Setter Defense
     * @param defense Defense
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Getter Power
     * @return Power
     */
    public int getPower() {
        return power;
    }

    /**
     * Setter Power
     * @param power Power
     */
    public void setPower(int power) {
        this.power = power;
    }
}
