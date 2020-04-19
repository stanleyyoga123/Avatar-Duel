package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * Controller for close card
 */

public class CloseCardLayoutController implements CardLayout {
    @FXML private VBox parent;

    /**
     * Getter Parent
     * @return VBox
     */
    public VBox getParent() { return parent; }

    /**
     * Get actual width
     * @return width
     */
    @Override
    public double getWidth() { return 0; }

    /**
     * Get actual height
     * @return height
     */
    @Override
    public double getHeight() { return 0; }

}
