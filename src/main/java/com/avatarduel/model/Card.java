package com.avatarduel.model;

public abstract class Card {
    private String name;
    private Element element;
    private String description;
    private String path;


    public void setName(String name){
        this.name = name;
    }

    public void setElement(Element element){
        this.element = element;
    }

    public void setDescription(String description){ this.description = description; }

    public void setPath(String path){ this.path = path; }

    public abstract void setEffect(Effect effect);

    public abstract void setAttack(int attack);

    public abstract void setDefense(int defense);

    public abstract void setPower(int power);

    public Element getElement(){ return this.element; }

    public String getName(){ return this.name; }

    public String getDescription(){ return this.description; }

    public String getPath(){ return this.path; }

    public abstract int getAttack();

    public abstract int getDefense();

    public abstract int getPower();

    public abstract Effect getEffect();

}
