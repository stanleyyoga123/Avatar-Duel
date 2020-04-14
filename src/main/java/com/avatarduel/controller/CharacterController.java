package com.avatarduel.controller;

import com.avatarduel.model.Card;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.type.Element;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class CharacterController implements CardLayout {

    private MidFieldController mid;
    private CardHandController hand;

    private static final int LEFT_ELLIPSE_RADIUS = 100;
    private static final int LEFT_TOP_HEIGHT = 40;
    private static final int LEFT_IMAGE_SIZE = 170;
    private static final int LEFT_PREF_WIDTH = 263;
    private static final int LEFT_PREF_HEIGHT = 400;
    private static final int LEFT_FONT_SIZE = 15;

    private double width = 400;
    private double height = 650;

    @FXML private VBox parent;

    public VBox getParent() {
        return parent;
    }

    public double getWidth() { return this.width; }

    public double getHeight() { return this.height; }

    @FXML
    void enter(MouseEvent event) {
    }

    @FXML
    void exit(MouseEvent event) throws IOException {
    }
}
