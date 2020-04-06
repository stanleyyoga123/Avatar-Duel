package com.avatarduel.controller;


import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class CloseCardController implements Card{

    private CardHandController cardController;
    private MidFieldController midFieldController;
    private ArenaController arenaController;

    @FXML private VBox parent;
    @FXML private Ellipse ellipse;

    @Override
    public void init(CardHandController cardController) {
        this.cardController = cardController;
    }

    @Override
    public void init(MidFieldController mfc) {
        this.midFieldController = mfc;
    }

    @Override
    public void init(ArenaController arc) {
        this.arenaController = arc;
    }

    public VBox getParent() {
        return parent;
    }

    @Override
    public HBox getCardTop() {
        return null;
    }

    @Override
    public Text getTextName() {
        return null;
    }

    @Override
    public ImageView getCardElement() {
        return null;
    }

    @Override
    public HBox getCardBody() {
        return null;
    }

    @Override
    public ImageView getCardImage() {
        return null;
    }

    @Override
    public VBox getCardBottom() {
        return null;
    }

    @Override
    public Text getTextDescription() {
        return null;
    }

    @Override
    public Text getDefense() {
        return null;
    }

    @Override
    public Text getAttack() {
        return null;
    }

    @Override
    public Text getPower() {
        return null;
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

}
