package com.avatarduel.model;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;

public abstract class Card {
    private String name;
    private Element element;
    private String description;

    public Card(String name, Element element, String description) {
        this.name = name;
        this.element = element;
        this.description = description;
    }

    public abstract void setAttribute(Attribute attribute);

    public Element getElement(){ return this.element; }

    public String getName(){ return this.name; }

    public String getDescription(){ return this.description; }

    public abstract Attribute getAttribute();

    public abstract Effect getEffect();

}
