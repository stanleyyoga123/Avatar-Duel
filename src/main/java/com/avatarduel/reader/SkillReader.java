package com.avatarduel.reader;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Effect;
import com.avatarduel.model.Skill;
import com.avatarduel.model.type.Element;
import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read Skill from CSV
 */

public class SkillReader extends CardReader{

    private List<Skill> skillList;

    /**
     * Constructor for Skill Reader
     */
    public SkillReader(){
        skillList = new ArrayList<Skill>();
    }

    /**
     * Load Skill Cards
     * @throws IOException Input Output
     * @throws URISyntaxException URI
     */
    @Override
    public void loadCards() throws IOException, URISyntaxException {
        File skillCSVFile = new File(getClass().getResource(SKILL_CSV_FILE_PATH).toURI());
        CSVReader characterReader = new CSVReader(skillCSVFile, "\t");
        characterReader.setSkipHeader(true);

        List<String[]> skillRows = characterReader.read();
        for (String[] row : skillRows) {
            skillList.add(
                    new Skill(
                            row[1],
                            Element.valueOf(row[2]),
                            row[3],
                            row[8],
                            new Attribute(
                                    Integer.valueOf(row[6]),
                                    Integer.valueOf(row[7]),
                                    Integer.valueOf(row[5])
                            )
                    )
            );
        }
    }

    /**
     * Getter for List of Skill
     * @return List of Skill
     */
    public List<Skill> getSkillList(){ return this.skillList; }
}
