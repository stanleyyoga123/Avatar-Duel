package com.avatarduel.builder;

import com.avatarduel.model.Character;
import com.avatarduel.model.Element;

public class CharacterBuilder {
    /**
     * Builder Pattern for Character
     */

    private String name;
    private Element element;
    private String description;
    private int attack;
    private int defense;
    private int power;

    public Character build(){
        Character ret = new Character();
        ret.setName(name);
        ret.setElement(element);
        ret.setDescription(description);
        ret.setAttack(attack);
        ret.setDefense(defense);
        ret.setPower(power);
        return ret;
    }

    public CharacterBuilder name(String name){
        this.name = name;
        return this;
    }

    public CharacterBuilder element(Element element){
        this.element = element;
        return this;
    }

    public CharacterBuilder description(String description){
        this.description = description;
        return this;
    }

    public CharacterBuilder attack(int attack){
        this.attack = attack;
        return this;
    }

    public CharacterBuilder defense(int defense){
        this.defense = defense;
        return this;
    }

    public CharacterBuilder power(int power){
        this.power = power;
        return this;
    }
}
