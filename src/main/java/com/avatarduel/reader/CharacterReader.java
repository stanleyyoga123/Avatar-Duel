package com.avatarduel.reader;

import com.avatarduel.model.Character;
import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Element;
import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CharacterReader extends CardReader {

    private List<Character> characterList;

    /**
     * Constructor
     */
    public CharacterReader(){
        characterList = new ArrayList<Character>();
    }

    @Override
    public void loadCards() throws IOException, URISyntaxException {
        File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
        CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
        characterReader.setSkipHeader(true);

        List<String[]> characterRows = characterReader.read();
        for (String[] row : characterRows) {
            characterList.add(
                    new Character(
                            row[1],
                            Element.valueOf(row[2]),
                            row[3],
                            new Attribute(
                                    Integer.valueOf(row[5]),
                                    Integer.valueOf(row[6]),
                                    Integer.valueOf(row[7])
                            )
                    )
            );
        }
    }

    public List<Character> getCharacterList(){ return this.characterList; }
}
