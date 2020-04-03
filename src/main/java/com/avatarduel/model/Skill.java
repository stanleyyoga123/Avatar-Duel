package com.avatarduel.model;

public class Skill {
    private String name;
    private String description;
    private Element element;
    private Effect effect;
    private int attack;
    private int defense;
    private int power;

    public Skill(){}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Element getElement() {
        return element;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getPower() {
        return power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
