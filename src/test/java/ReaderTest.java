
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.avatarduel.reader.*;
import com.avatarduel.model.Character;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Land;

import org.junit.Test;
public class ReaderTest {
    @Test
    public void CharacterReaderTester(){
        CharacterReader c = new CharacterReader();
        assertEquals(c.getCharacterList(), new ArrayList<Character>());
        try{
            c.loadCards();
        }
        catch(Exception e){
    
        }
        assertEquals(c.getCharacterList().size(),58);
    }

    @Test
    public void SkillReaderTester(){
        SkillReader s = new SkillReader();
        assertEquals(s.getSkillList(), new ArrayList<Skill>());
        try{
            s.loadCards();
        }
        catch(Exception e){

        }
        assertEquals(s.getSkillList().size(), 28);
    }

    @Test
    public void LandReaderTester(){
        LandReader l = new LandReader();
        assertEquals(l.getLandList(), new ArrayList<Land>());
        try{
            l.loadCards();
        }
        catch(Exception e){
        
        }
        assertEquals(l.getLandList().size(), 20);
    }
}