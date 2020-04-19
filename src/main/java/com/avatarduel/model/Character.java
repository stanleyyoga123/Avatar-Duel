package com.avatarduel.model;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;

/**
 * Class for Character Card
 */

public class Character extends Card{
    private Attribute attribute;

    /**
     * Constructor for Character
     * @param name Name
     * @param element Element
     * @param description Description
     * @param attribute Attribute
     */
    public Character(String name, Element element, String description, Attribute attribute) {
        super(name, element, description);
        this.attribute = attribute;
    }

    /**
     * Attribute Setter
     * @param attribute Attribute
     */
    @Override
    public void setAttribute(Attribute attribute) { this.attribute = attribute; }

    /**
     * Attribute Getter
     * @return Attribute
     */
    @Override
    public Attribute getAttribute() { return attribute; }

    /**
     * Effect Getter
     * @return Effectd
     */
    @Override
    public Effect getEffect() { return null; }
}
