package com.avatarduel.controller;


import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class CloseCardController implements Card{
    @FXML private VBox parent;

    public VBox getParent() {
        return parent;
    }

    @Override
    public double getWidth() { return 0; }

    @Override
    public double getHeight() { return 0; }

}
