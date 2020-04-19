import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import com.avatarduel.model.attribute.*;
import com.avatarduel.model.type.*;
import com.avatarduel.model.Card;
import com.avatarduel.model.Character;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.model.Player;

import org.junit.Test;

public class ModelTest {
    @Test
    public void characterTester(){
        Attribute attribute = new Attribute(0,1,2);
        Character test = new Character("Test", Element.WATER, "test description", attribute);

        assertTrue(test instanceof Card);

        assertEquals(test.getName(), "Test");
        assertEquals(test.getElement(), Element.WATER);
        assertEquals(test.getDescription(), "test description");
        assertEquals(test.getEffect(), null);
        assertEquals(test.getAttribute().getAttack(), 0);
        assertEquals(test.getAttribute().getDefense(), 1);
        assertEquals(test.getAttribute().getPower(), 2);

        Attribute attribute2 = new Attribute(2,3,0);
        test.setAttribute(attribute2);

        assertEquals(test.getAttribute().getAttack(), 2);
        assertEquals(test.getAttribute().getDefense(), 3);
        assertEquals(test.getAttribute().getPower(), 0);
    }

    @Test
    public void landTester(){
        Attribute attribute = new Attribute(0,1,2);
        Land test = new Land("Test", Element.FIRE, "test description");

        assertTrue(test instanceof Card);

        assertEquals(test.getName(), "Test");
        assertEquals(test.getElement(), Element.FIRE);
        assertEquals(test.getDescription(), "test description");
        assertEquals(test.getEffect(), null);
        assertEquals(test.getAttribute().getAttack(), 0);
        assertEquals(test.getAttribute().getDefense(), 0);
        assertEquals(test.getAttribute().getPower(), 0);

        test.setAttribute(attribute);

        assertEquals(test.getAttribute().getAttack(), 0);
        assertEquals(test.getAttribute().getDefense(), 0);
        assertEquals(test.getAttribute().getPower(), 0);
    }

    @Test
    public void skillTester(){
        Attribute attribute = new Attribute(0,0,0);
        Skill s = new Skill("Skill Card", Element.WATER, "Skill Desc", Effect.POWER_UP, attribute);

        assertTrue(s instanceof Card);
        
        assertEquals(s.getName(), "Skill Card");
        assertEquals(s.getElement(), Element.WATER);
        assertEquals(s.getDescription(), "Skill Desc");
        assertEquals(s.getEffect(), Effect.POWER_UP);
        assertEquals(s.getAttribute().getAttack(), 0);
        assertEquals(s.getAttribute().getDefense(), 0);
        assertEquals(s.getAttribute().getPower(), 0);

        attribute = new Attribute(1,2,3);
        s.setAttribute(attribute);

        assertEquals(s.getAttribute().getAttack(), 1);
        assertEquals(s.getAttribute().getDefense(), 2);
        assertEquals(s.getAttribute().getPower(), 3);
    }

    @Test
    public void playerTest(){
        Player p = new Player(new ArrayList<Card>(), 10, false, new MidDeck(new ArrayList<Card>(), new ArrayList<Card>()), new Deck(), new Power(0,0,0,0,0), new RemainingPower(0,0,0,0,0));
        
        assertTrue(p.getHandDeck() instanceof ArrayList);
        assertEquals(p.getHealth(), 10);
        assertEquals(p.isPlayedLand(), false);
        assertTrue(p.getMidDeck() instanceof MidDeck);
        assertTrue(p.getDrawDeck() instanceof Deck);
        assertTrue(p.getPower() instanceof Power);
        assertTrue(p.getRemPower() instanceof RemainingPower);
    }
}
