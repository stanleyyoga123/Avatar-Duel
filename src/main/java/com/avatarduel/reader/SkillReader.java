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
        System.out.println("BACA");
        System.out.println(skillRows.get(0)[8]);
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
        System.out.println("KELUAR");
    }

    public List<Skill> getSkillList(){ return this.skillList; }
}
