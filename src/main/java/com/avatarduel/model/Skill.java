package com.avatarduel.model;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;

public class Skill extends Card{
    private Effect effect;
    private Attribute attribute;

    public Skill(String name, Element element, String description, Effect effect, Attribute attribute) {
        super(name, element, description);
        this.effect = effect;
        this.attribute = attribute;
    }

    @Override
    public void setAttribute(Attribute attribute) { this.attribute = attribute; }

    @Override
    public Attribute getAttribute() { return attribute; }

    @Override
    public Effect getEffect() { return effect; }
}
