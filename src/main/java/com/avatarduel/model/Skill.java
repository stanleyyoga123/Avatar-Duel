package com.avatarduel.model;

public class Skill extends Card{
    private Effect effect;
    private int attack;
    private int defense;
    private int power;

    public Skill(){}

    public Effect getEffect() { return effect; }

    public int getAttack() { return attack; }

    public int getDefense() { return defense; }

    public int getPower() { return power; }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public void setAttack(int attack) { this.attack = attack; }

    public void setDefense(int defense) { this.defense = defense; }

    public void setPower(int power) { this.power = power; }
}
