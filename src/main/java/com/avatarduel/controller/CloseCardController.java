package com.avatarduel.controller;


import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class CloseCardController {

    @FXML private VBox parent;
    @FXML private Rectangle rect;

    public VBox getParent() {
        return parent;
    }

    public Rectangle getRect() {
        return rect;
    }

}
