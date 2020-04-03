package com.avatarduel.loader;

import com.avatarduel.controller.Land;

public class LandLoader extends CardLoader {

    public LandLoader(String cardFXML, String cardName, String cardDescription) {
        super(cardFXML, cardName, cardDescription);
    }

    @Override
    public void init() {
        this.loader.setLocation(getClass().getResource(FXML_PATH + this.cardFXML + ".fxml"));
        Land land = new Land(this.cardName, this.cardDescription, IMAGE_PATH + "land/" + this.cardName + ".png");
        this.loader.setController(land);
    }
}
