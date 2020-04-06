package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class LandController implements Card{

    private double width = 400;
    private double height = 650;

    @FXML private VBox parent;

    public VBox getParent() { return this.parent; }

    public double getWidth() { return this.width; }

    public double getHeight() { return this.height; }
}
