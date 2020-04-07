package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class SkillController implements CardLayout {

    private double width = 400;
    private double height = 650;

    @FXML private VBox parent;

    public VBox getParent() {
        return parent;
    }

    public double getWidth() { return this.width; }

    public double getHeight() { return this.height; }
}
