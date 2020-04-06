package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class SkillController implements Card{

    private CardHandController cardController;
    private MidFieldController midFieldController;
    private ArenaController arenaController;

    private double width = 400;
    private double height = 650;

    @FXML private VBox parent;
    @FXML private HBox cardTop;
    @FXML private Text textName;
    @FXML private ImageView cardElement;
    @FXML private HBox cardBody;
    @FXML private ImageView cardImage;
    @FXML private VBox cardBottom;
    @FXML private Text textDescription;
    @FXML private Text attack;
    @FXML private Text defense;
    @FXML private Text power;

    public void init(CardHandController cardController) {
        this.cardController = cardController;
    }

    public void init(MidFieldController mfc) {
        this.midFieldController = mfc;
    }

    public void init(ArenaController arc) {
        this.arenaController = arc;
    }
    public VBox getParent() {
        return parent;
    }

    public HBox getCardTop() {
        return cardTop;
    }

    public Text getTextName() {
        return textName;
    }

    public ImageView getCardElement() {
        return cardElement;
    }

    public HBox getCardBody() {
        return cardBody;
    }

    public ImageView getCardImage() {
        return cardImage;
    }

    public VBox getCardBottom() {
        return cardBottom;
    }

    public Text getTextDescription() {
        return textDescription;
    }

    public Text getAttack() {
        return attack;
    }

    public Text getDefense() {
        return defense;
    }

    public Text getPower() {
        return power;
    }

    public double getWidth() { return this.width; }

    public double getHeight() { return this.height; }

    @Override
    public Ellipse getEllipse() {
        return null;
    }
}
