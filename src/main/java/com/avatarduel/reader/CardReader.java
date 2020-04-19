package com.avatarduel.reader;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Abstract class for Reader
 */

public abstract class CardReader {
    protected static final String LAND_CSV_FILE_PATH = "../card/data/land.csv";
    protected static final String CHARACTER_CSV_FILE_PATH = "../card/data/character.csv";
    protected static final String SKILL_CSV_FILE_PATH = "../card/data/skill_aura.csv";

    /**
     * Method to load from CSV
     * @throws IOException Input Output
     * @throws URISyntaxException URI
     */
    public abstract void loadCards() throws IOException, URISyntaxException;
}
