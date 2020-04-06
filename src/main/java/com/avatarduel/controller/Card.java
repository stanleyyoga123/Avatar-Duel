package com.avatarduel.controller;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public interface Card {
    public void init(CardHandController cardController);
    public void init(MidFieldController mfc);
    public void init(ArenaController arc);
    public VBox getParent();
    public HBox getCardTop();
    public Text getTextName();
    public ImageView getCardElement();
    public HBox getCardBody();
    public ImageView getCardImage();
    public VBox getCardBottom();
    public Text getTextDescription();
    public Text getDefense();
    public Text getAttack();
    public Text getPower();
    public Ellipse getEllipse();
    public double getWidth();
    public double getHeight();
}
