package com.avatarduel.loader;

import javafx.fxml.FXMLLoader;

public abstract class CardLoader extends Loader {

    protected String cardName;
    protected String cardFXML;
    protected String cardDescription;

    /**
     * Constructor
     *
     * @param cardFXML
     * @param cardName
     * @param cardDescription
     */
    public CardLoader(String cardFXML, String cardName, String cardDescription){
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardFXML = cardFXML;
        this.loader = new FXMLLoader();
    }

    public abstract void init();

    @Override
    public FXMLLoader getLoader(){
        return this.loader;
    }
}
