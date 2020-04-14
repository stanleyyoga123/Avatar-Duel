package com.avatarduel.reader;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class CardReader {
    protected static final String LAND_CSV_FILE_PATH = "../card/data/land.csv";
    protected static final String CHARACTER_CSV_FILE_PATH = "../card/data/character.csv";
    protected static final String SKILL_CSV_FILE_PATH = "../card/data/skill_aura.csv";

    /**
     * Function to load from CSV
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public abstract void loadCards() throws IOException, URISyntaxException;
}
