package com.avatarduel.reader;

import com.avatarduel.builder.CharacterBuilder;
import com.avatarduel.model.Character;
import com.avatarduel.model.Element;
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
                    new CharacterBuilder()
                            .name(row[1])
                            .element(Element.valueOf(row[2]))
                            .description(row[3])
                            .attack(Integer.valueOf(row[5]))
                            .defense(Integer.valueOf(row[6]))
                            .power(Integer.valueOf(row[7]))
                            .build()
            );
        }
    }

    public List<Character> getCharacterList(){ return this.characterList; }
}
