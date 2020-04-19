package com.avatarduel.model;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;

/**
 * Class for Land Card
 */

public class Land extends Card {

  /**
   * Constructor for Land
   * @param name Name
   * @param element Element
   * @param description Description
   */
  public Land(String name, Element element, String description) {
    super(name, element, description);
  }

  /**
   * Attribute Setter
   * @param attribute Attribute
   */
  @Override
  public void setAttribute(Attribute attribute) { }

  /**
   * Attribute Getter
   * @return Attribute
   */
  @Override
  public Attribute getAttribute() { return new Attribute(0, 0, 0); }

  /**
   * Effect Getter
   * @return Effect
   */
  @Override
  public Effect getEffect() { return null; }
}