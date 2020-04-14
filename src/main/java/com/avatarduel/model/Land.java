package com.avatarduel.model;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;

public class Land extends Card {
  private String name;
  private String description;

  public Land(String name, Element element, String description) {
    super(name, element, description);
  }

  @Override
  public void setAttribute(Attribute attribute) { }

  @Override
  public Attribute getAttribute() { return new Attribute(0, 0, 0); }

  @Override
  public Effect getEffect() { return null; }
}