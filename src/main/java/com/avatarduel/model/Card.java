package com.avatarduel.model;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;

/**
 * Abstract Class for Card
 */

public abstract class Card {
    private String name;
    private Element element;
    private String description;

    /**
     * Constructor for Card
     * @param name Name
     * @param element Element
     * @param description Description
     */
    public Card(String name, Element element, String description) {
        this.name = name;
        this.element = element;
        this.description = description;
    }

    public abstract void setAttribute(Attribute attribute);

    /**
     * Getter for Element
     * @return Element
     */
    public Element getElement(){ return this.element; }

    /**
     * Getter for Name
     * @return Name
     */
    public String getName(){ return this.name; }

    /**
     * Getter for Description
     * @return Description
     */
    public String getDescription(){ return this.description; }

    public abstract Attribute getAttribute();

    public abstract Effect getEffect();

}
