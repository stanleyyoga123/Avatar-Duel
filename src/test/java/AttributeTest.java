import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import com.avatarduel.model.attribute.*;
import com.avatarduel.model.Card;
import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.*;
import com.avatarduel.model.Character;
import com.avatarduel.model.Skill;

import org.junit.Test;
public class AttributeTest {
    @Test
    public void attributeTester(){
        Attribute attr = new Attribute(0, 0, 0);
        assertEquals(attr.getAttack(), 0);
        assertEquals(attr.getDefense(), 0);
        assertEquals(attr.getPower(), 0);
        attr.setAttack(1);
        attr.setDefense(2);
        attr.setPower(3);
        assertEquals(attr.getAttack(), 1);
        assertEquals(attr.getDefense(), 2);
        assertEquals(attr.getPower(), 3);
    }

    @Test
    public void deckTester(){
        Deck deck = new Deck();
        
        assertEquals(deck.getCardSize(),75);
        assertTrue(deck.draw() instanceof Card);
        assertEquals(deck.getCardSize(), 74);
    }

    @Test
    public void midDeckTester(){
        MidDeck md = new  MidDeck(new ArrayList<Card>(), new ArrayList<Card>());
        
        assertTrue(md.getMidTopDeck() instanceof ArrayList);
        assertTrue(md.getMidBotDeck() instanceof ArrayList);

        Attribute attribute = new Attribute(0,1,2);
        Character c = new Character("Char Card", Element.WATER, "test description", attribute);
        Skill s = new Skill("Skill Card", Element.WATER, "Skill Desc", Effect.POWER_UP, attribute);

        md.getMidTopDeck().add(c);
        md.getMidBotDeck().add(s);

        assertEquals(md.getMidTopDeck().size(), 1);
        assertEquals(md.getMidBotDeck().size(), 1);
    }

    @Test
    public void powerTester(){
        Power p = new Power(0, 0, 0, 0, 0);
        assertEquals(p.getAirPower(), 0);
        assertEquals(p.getEarthPower(), 0);
        assertEquals(p.getEnergyPower(), 0);
        assertEquals(p.getFirePower(), 0);
        assertEquals(p.getWaterPower(), 0);
        p.setAirPower(1);
        p.setEarthPower(2);
        p.setEnergyPower(3);
        p.setFirePower(4);
        p.setWaterPower(5);
        assertEquals(p.getAirPower(), 1);
        assertEquals(p.getEarthPower(), 2);
        assertEquals(p.getEnergyPower(), 3);
        assertEquals(p.getFirePower(), 4);
        assertEquals(p.getWaterPower(), 5);
    }

    @Test
    public void remainingPowerTester(){
        RemainingPower rp = new RemainingPower(0, 0, 0, 0, 0);
        assertEquals(rp.getRemainingAir(), 0);
        assertEquals(rp.getRemainingEarth(), 0);
        assertEquals(rp.getRemainingEnergy(), 0);
        assertEquals(rp.getRemainingFire(), 0);
        assertEquals(rp.getRemainingWater(), 0);
        rp.setRemainingAir(1);
        rp.setRemainingEarth(2);
        rp.setRemainingEnergy(3);
        rp.setRemainingFire(4);
        rp.setRemainingWater(5);
        assertEquals(rp.getRemainingAir(), 1);
        assertEquals(rp.getRemainingEarth(), 2);
        assertEquals(rp.getRemainingEnergy(), 3);
        assertEquals(rp.getRemainingFire(), 4);
        assertEquals(rp.getRemainingWater(), 5);
    }
}