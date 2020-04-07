package com.avatarduel.model;

public class Land extends Card {
  private String name;
  private String description;
  private Element element;

  public Land(){}


  @Override
  public void setEffect(Effect effect) {}

  @Override
  public void setAttack(int attack) {}

  @Override
  public void setDefense(int defense) {}

  @Override
  public void setPower(int power) {}

  @Override
  public int getAttack() { return 0; }

  @Override
  public int getDefense() { return 0; }

  @Override
  public int getPower() { return 0; }

  @Override
  public Effect getEffect() { return null; }
}