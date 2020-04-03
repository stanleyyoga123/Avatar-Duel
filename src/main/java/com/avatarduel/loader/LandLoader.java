package com.avatarduel.loader;

import com.avatarduel.controller.LandController;

public class LandLoader extends CardLoader {

    /**
     * Constructor
     *
     * @param cardFXML
     * @param cardName
     * @param cardDescription
     */
    public LandLoader(String cardFXML, String cardName, String cardDescription) {
        super(cardFXML, cardName, cardDescription);
    }

    @Override
    public void init() {
        this.loader.setLocation(getClass().getResource(FXML_PATH + this.cardFXML + ".fxml"));
        LandController land = new LandController(this.cardName, this.cardDescription, IMAGE_PATH + "land/" + this.cardName + ".png");
        this.loader.setController(land);
    }
}
