package com.avatarduel.builder;

import com.avatarduel.model.Effect;
import com.avatarduel.model.Element;
import com.avatarduel.model.Skill;

public class SkillBuilder {
    /**
     * Builder Pattern for Skill
     */

    private String name;
    private String description;
    private Element element;
    private Effect effect;
    private int attack;
    private int defense;
    private int power;

    public Skill build(){
        Skill ret = new Skill();
        ret.setName(name);
        ret.setDescription(description);
        ret.setElement(element);
        ret.setEffect(effect);
        ret.setAttack(attack);
        ret.setDefense(defense);
        ret.setPower(power);
        return ret;
    }

    public SkillBuilder name(String name){
        this.name = name;
        return this;
    }

    public SkillBuilder description(String description){
        this.description = description;
        return this;
    }

    public SkillBuilder element(Element element){
        this.element = element;
        return this;
    }

    public SkillBuilder effect(Effect effect){
        this.effect = effect;
        return this;
    }

    public SkillBuilder attack(int attack){
        this.attack = attack;
        return this;
    }

    public SkillBuilder defense(int defense){
        this.defense = defense;
        return this;
    }

    public SkillBuilder power(int power){
        this.power = power;
        return this;
    }
}
