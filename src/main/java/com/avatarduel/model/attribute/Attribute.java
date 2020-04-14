package com.avatarduel.model.attribute;

public class Attribute {
    private int attack;
    private int defense;
    private int power;

    public Attribute(int attack, int defense, int power) {
        this.attack = attack;
        this.defense = defense;
        this.power = power;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
