package com.avatarduel.loader;

import com.avatarduel.controller.LandController;

public class CharacterLoader extends CardLoader {

    /**
     * Constructor
     *
     * @param cardFXML
     * @param cardName
     * @param cardDescription
     */
    public CharacterLoader(String cardFXML, String cardName, String cardDescription) {
        super(cardFXML, cardName, cardDescription);
    }

    @Override
    public void init() {
        this.loader.setLocation(getClass().getResource(FXML_PATH + this.cardFXML + ".fxml"));
        LandController land = new LandController(this.cardName, this.cardDescription, IMAGE_PATH + "character/" + this.cardName + ".png");
        this.loader.setController(land);
    }
}
