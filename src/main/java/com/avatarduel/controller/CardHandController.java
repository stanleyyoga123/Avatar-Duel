package com.avatarduel.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class CardHandController {

    private ArenaController main;

    @FXML private HBox hbox;

    public HBox getHbox() {
        return hbox;
    }

    public void init(ArenaController arc) { this.main = arc; }

    public ArenaController getMain() { return this.main; }

}
