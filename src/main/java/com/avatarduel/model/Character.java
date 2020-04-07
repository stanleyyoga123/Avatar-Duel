package com.avatarduel.model;

public class Character extends Card{
    private int attack;
    private int defense;
    private int power;

    public Character(){}

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public void setPower(int power){
        this.power = power;
    }

    public void setEffect(Effect effect) {}

    public int getAttack(){ return this.attack; }

    public int getDefense(){
        return this.defense;
    }

    public int getPower(){ return this.power; }

    public Effect getEffect() { return null; }
}
