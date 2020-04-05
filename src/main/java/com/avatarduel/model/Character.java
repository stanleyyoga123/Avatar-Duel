package com.avatarduel.model;

public class Character {
    private String name;
    private Element element;
    private String description;
    private int attack;
    private int defense;
    private int power;
    private String path;

    public Character(){}

    public void setName(String name){
        this.name = name;
    }

    public void setElement(Element element){
        this.element = element;
    }

    public void setDescription(String description){ this.description = description; }

    public void setPath(String path){ this.path = path; }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public void setPower(int power){
        this.power = power;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String getPath(){ return this.path; }

    public Element getElement(){
        return this.element;
    }

    public int getAttack(){
        return this.attack;
    }

    public int getDefense(){
        return this.defense;
    }

    public int getPower(){ return this.power; }
}
