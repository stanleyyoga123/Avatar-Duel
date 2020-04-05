package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LandController {

    private CardHandController cardController;
    private MidFieldController midFieldController;
    private ArenaController arenaController;

    private double width = 400;
    private double height = 650;

    @FXML private VBox parent;
    @FXML private HBox cardTop;
    @FXML private VBox cardBottom;
    @FXML private HBox cardBody;
    @FXML private ImageView cardImage;
    @FXML private Text textName;
    @FXML private Text textDescription;

    public void init(CardHandController cardController) {
        this.cardController = cardController;
    }

    public void init(MidFieldController mfc) {
        this.midFieldController = mfc;
    }

    public void init(ArenaController arc) {
        this.arenaController = arc;
    }

    public VBox getParent() { return this.parent; }

    public ImageView getCardImage() { return this.cardImage; }

    public HBox getCardTop() { return this.cardTop; }

    public VBox getCardBottom() { return this.cardBottom; }

    public HBox getCardBody() { return this.cardBody; }

    public Text getTextName() { return this.textName; }

    public Text getTextDescription() { return this.textDescription; }

    public double getWidth() { return this.width; }

    public double getHeight() { return this.height; }
}
