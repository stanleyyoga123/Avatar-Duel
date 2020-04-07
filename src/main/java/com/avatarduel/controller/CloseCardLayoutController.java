package com.avatarduel.controller;


import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class CloseCardLayoutController implements CardLayout {
    @FXML private VBox parent;

    public VBox getParent() {
        return parent;
    }

    @Override
    public double getWidth() { return 0; }

    @Override
    public double getHeight() { return 0; }

}
