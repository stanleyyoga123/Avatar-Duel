package com.avatarduel.model;

public class Land {
  private String name;
  private String description;
  private Element element;

  public Land() {
    this.name = "";
    this.description = "";
    this.element = Element.AIR;
  }

  public Land(String name, String description, Element element) {
    this.name = name;
    this.description = description;
    this.element = element;
  }

  public String getName(){
    return this.name;
  }

  public String getDescription(){
    return this.description;
  }

  public Element getElement(){
    return this.element;
  }

  public void setName(String name) { this.name = name; }

  public void setDescription(String description) { this.description = description; }

  public void setElement(Element element) { this.element = element; }
}