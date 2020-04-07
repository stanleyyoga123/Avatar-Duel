package com.avatarduel.reader;

import com.avatarduel.builder.SkillBuilder;
import com.avatarduel.model.Effect;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Element;
import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class SkillReader extends CardReader{

    private List<Skill> skillList;

    /**
     * Constructor
     */
    public SkillReader(){
        skillList = new ArrayList<Skill>();
    }

    @Override
    public void loadCards() throws IOException, URISyntaxException {
        File skillCSVFile = new File(getClass().getResource(SKILL_CSV_FILE_PATH).toURI());
        CSVReader characterReader = new CSVReader(skillCSVFile, "\t");
        characterReader.setSkipHeader(true);

        List<String[]> skillRows = characterReader.read();
        for (String[] row : skillRows) {
            skillList.add(
                    new SkillBuilder()
                            .name(row[1])
                            .element(Element.valueOf(row[2]))
                            .description(row[3])
                            .effect(Effect.AURA)
                            .build()
            );
        }
    }

    public List<Skill> getSkillList(){ return this.skillList; }
}
