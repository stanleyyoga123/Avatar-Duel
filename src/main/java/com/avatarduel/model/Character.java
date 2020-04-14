package com.avatarduel.model;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;

public class Character extends Card{
    private Attribute attribute;

    public Character(String name, Element element, String description, Attribute attribute) {
        super(name, element, description);
        this.attribute = attribute;
    }

    @Override
    public void setAttribute(Attribute attribute) { this.attribute = attribute; }

    @Override
    public Attribute getAttribute() { return attribute; }

    @Override
    public Effect getEffect() { return null; }
}
