package com.avatarduel.model;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;

/**
 * Class for Skill Card
 */

public class Skill extends Card{
    private Effect effect;
    private Attribute attribute;

    /**
     * Skill Constructor
     * @param name Name
     * @param element Element
     * @param description Description
     * @param effect Effect
     * @param attribute Attribute
     */
    public Skill(String name, Element element, String description, Effect effect, Attribute attribute) {
        super(name, element, description);
        this.effect = effect;
        this.attribute = attribute;
    }

    /**
     * Skill Constructor
     * @param name Name
     * @param element Element
     * @param description Description
     * @param effect Effect
     * @param attribute Attribute
     */
    public Skill(String name, Element element, String description, String effect, Attribute attribute) {
        super(name, element, description);
        this.effect = Effect.valueOf(effect);
        this.attribute = attribute;
    }

    /**
     * Attribute Setter
     * @param attribute Attribute
     */
    @Override
    public void setAttribute(Attribute attribute) { this.attribute = attribute; }

    /**
     * Attribute Setter
     * @return Attribute
     */
    @Override
    public Attribute getAttribute() { return attribute; }

    /**
     * Effect Getter
     * @return Effect
     */
    @Override
    public Effect getEffect() { return effect; }
}
