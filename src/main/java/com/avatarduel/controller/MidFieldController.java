package com.avatarduel.controller;

import java.util.ArrayList;

import com.avatarduel.model.Card;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MidFieldController {

    private ArenaController main;

    @FXML private HBox hbox;

    public HBox getHbox() {
        return hbox;
    }

    public void init(ArenaController arc) {
        this.main = arc;
    }

    public ArenaController getMain() { return this.main; }

}

