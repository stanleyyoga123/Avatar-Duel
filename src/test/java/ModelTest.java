import static org.junit.Assert.assertEquals;

import com.avatarduel.model.attribute.Attribute;
import com.avatarduel.model.type.Element;
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

    public void landTester(){
        Attribute attribute = new Attribute(0,1,2);
        Land test = new Land("Test", Element.FIRE, "test description");

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
}
