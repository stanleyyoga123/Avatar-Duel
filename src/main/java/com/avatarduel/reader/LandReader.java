package com.avatarduel.reader;

import com.avatarduel.builder.LandBuilder;
import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class LandReader extends CardReader{

    List<Land> landList;

    /**
     * Constructor
     */
    public LandReader(){
        landList = new ArrayList<Land>();
    }

    @Override
    public void loadCards() throws IOException, URISyntaxException {
        File characterCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
        CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
        characterReader.setSkipHeader(true);

        List<String[]> landRows = characterReader.read();
        for (String[] row : landRows) {
            landList.add(
                    new LandBuilder()
                            .name(row[1])
                            .element(Element.valueOf(row[2]))
                            .description(row[3])
                            .build()
            );
        }
    }

    /**
     *
     * @return List of Land
     */
    public List<Land> getLandList(){
        return this.landList;
    }
}