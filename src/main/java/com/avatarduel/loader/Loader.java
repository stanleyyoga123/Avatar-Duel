package com.avatarduel.loader;

import javafx.fxml.FXMLLoader;

public abstract class Loader {
    protected FXMLLoader loader;
    protected static final String FXML_PATH = "../fxml/";
    protected static final String IMAGE_PATH = "../card/image/";
    protected static final String DATA_PATH = "../data/";

    /**
     * Initialize loader and controller
     */
    public abstract void init();

    /**
     *
     * @return FXMLLoader
     */
    public abstract FXMLLoader getLoader();
}
