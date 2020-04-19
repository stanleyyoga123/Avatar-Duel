package com.avatarduel.reader;

import com.avatarduel.model.type.Element;
import com.avatarduel.model.Land;
import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read Land from CSV
 */
public class LandReader extends CardReader{

    private List<Land> landList;

    /**
     * Constructor for LandReader
     */
    public LandReader(){
        landList = new ArrayList<Land>();
    }

    /**
     * Load Land Cards
     * @throws IOException Input Output
     * @throws URISyntaxException URI
     */
    @Override
    public void loadCards() throws IOException, URISyntaxException {
        File characterCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
        CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
        characterReader.setSkipHeader(true);

        List<String[]> landRows = characterReader.read();
        for (String[] row : landRows) {
            landList.add(
                    new Land(
                            row[1],
                            Element.valueOf(row[2]),
                            row[3]
                    )
            );
        }
    }

    /**
     * Getter for list of land
     * @return List of Land
     */
    public List<Land> getLandList(){
        return this.landList;
    }
}