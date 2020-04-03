package com.avatarduel.reader;

import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public abstract class CardReader {
    protected static final String LAND_CSV_FILE_PATH = "../card/data/land.csv";
    protected static final String CHARACTER_CSV_FILE_PATH = "../card/data/character.csv";
    protected static final String SKILL_CSV_FILE_PATH = "../card/data/character.csv";

    /**
     * Function to load from CSV
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public abstract void loadCards() throws IOException, URISyntaxException;
}
