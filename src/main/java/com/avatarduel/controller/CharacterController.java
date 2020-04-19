package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Controller for Card
 */

public class CharacterController implements CardLayout {

    private double width = 400;
    private double height = 650;

    @FXML private VBox parent;

    /**
     * Getter for Parent
     * @return VBox
     */
    public VBox getParent() { return parent; }

    /**
     * Getter actual width card
     * @return width
     */
    public double getWidth() { return this.width; }

    /**
     * Getter actual height card
     * @return height
     */
    public double getHeight() { return this.height; }

    /**
     * Mark that the card have enter event
     * @param event Event
     */
    @FXML
    void enter(MouseEvent event) { }

    /**
     * Mark that the card have exit event
     * @param event Event
     * @throws IOException Input Output
     */
    @FXML
    void exit(MouseEvent event) throws IOException { }
}
