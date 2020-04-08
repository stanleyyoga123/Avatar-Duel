package com.avatarduel.model;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import com.avatarduel.reader.CharacterReader;
import com.avatarduel.reader.LandReader;
import com.avatarduel.reader.SkillReader;

public class Deck {
    protected List<Card> cardsDeck;

    public Deck() {
        this.cardsDeck = new ArrayList<Card>();
        this.fillInCards();
    }

    private void fillInCards() {
        // Get List of Characters
        CharacterReader charRead = new CharacterReader();
        try {
            charRead.loadCards();
        }
        catch (Exception exc) {
            // do something about it
        }
        List<Character> listChar = charRead.getCharacterList();
        // Get List of Lands
        LandReader landRead = new LandReader();
        try {
            landRead.loadCards();
        }
        catch (Exception exc) {
            // do something about it
        }
        List<Land> listLand = landRead.getLandList();
        // Get List of Skills
        SkillReader skillRead = new SkillReader();
        try {
            skillRead.loadCards();
        }
        catch (Exception exc) {
            // do something about it
        }
        List<Skill> listSkill = skillRead.getSkillList();
        // Add cards randomly
        // Cards proportion in a deck (60) :
        // Number of Land Cards (24) : EARTH(6), AIR(6), WATER(6), FIRE(6)
        // Number of Character Cards (24) : EARTH(6), AIR(6), WATER(6), FIRE(6)
        // Number of Skill Cards (12) : EARTH(3), AIR(3), WATER(3), FIRE(3)
        // Solusi masih belum optimal
        Random random = new Random();
        int nEarth = 0;
        int nWater = 0;
        int nFire = 0;
        int nAir = 0;
        int randIdx;
        while (this.cardsDeck.size() < 24) {
            randIdx = random.nextInt(listChar.size());
            if (listChar.get(randIdx).getElement() == Element.AIR && nAir < 6) {
                this.cardsDeck.add(listChar.get(randIdx));
                listChar.remove(randIdx);
                nAir++;
            }
            else if (listChar.get(randIdx).getElement() == Element.FIRE && nFire < 6) {
                this.cardsDeck.add(listChar.get(randIdx));
                listChar.remove(randIdx);
                nFire++;
            }
            else if (listChar.get(randIdx).getElement() == Element.WATER && nWater < 6) {
                this.cardsDeck.add(listChar.get(randIdx));
                listChar.remove(randIdx);
                nWater++;
            }
            else if (listChar.get(randIdx).getElement() == Element.EARTH && nEarth < 6) {
                this.cardsDeck.add(listChar.get(randIdx));
                listChar.remove(randIdx);
                nEarth++;
            }
        }
        nWater = 0;
        nFire = 0;
        nAir = 0;
        nEarth = 0;
        while (this.cardsDeck.size() < 48) {
            randIdx = random.nextInt(listLand.size());
            if (listLand.get(randIdx).getElement() == Element.AIR && nAir < 6) {
                this.cardsDeck.add(listLand.get(randIdx));
                listLand.remove(randIdx);
                nAir++;
            }
            else if (listLand.get(randIdx).getElement() == Element.FIRE && nFire < 6) {
                this.cardsDeck.add(listLand.get(randIdx));
                listLand.remove(randIdx);
                nFire++;
            }
            else if (listLand.get(randIdx).getElement() == Element.WATER && nWater < 6) {
                this.cardsDeck.add(listLand.get(randIdx));
                listLand.remove(randIdx);
                nWater++;
            }
            else if (listLand.get(randIdx).getElement() == Element.EARTH && nEarth < 6) {
                this.cardsDeck.add(listLand.get(randIdx));
                listLand.remove(randIdx);
                nEarth++;
            }
        }
        nWater = 0;
        nFire = 0;
        nAir = 0;
        nEarth = 0;
        while (this.cardsDeck.size() < 60) {
            randIdx = random.nextInt(listSkill.size());
            if (listSkill.get(randIdx).getElement() == Element.AIR && nAir < 3) {
                this.cardsDeck.add(listSkill.get(randIdx));
                listSkill.remove(randIdx);
                nAir++;
            }
            else if (listSkill.get(randIdx).getElement() == Element.FIRE && nFire < 3) {
                this.cardsDeck.add(listSkill.get(randIdx));
                listSkill.remove(randIdx);
                nFire++;
            }
            else if (listSkill.get(randIdx).getElement() == Element.WATER && nWater < 3) {
                this.cardsDeck.add(listSkill.get(randIdx));
                listSkill.remove(randIdx);
                nWater++;
            }
            else if (listSkill.get(randIdx).getElement() == Element.EARTH && nEarth < 3) {
                this.cardsDeck.add(listSkill.get(randIdx));
                listSkill.remove(randIdx);
                nEarth++;
            }
        }
    }

    public Card drawCard() {
        Random random = new Random();
        int length = this.cardsDeck.size();
        int randomIndex = random.nextInt(length);
        Card retrievedCard = this.cardsDeck.get(randomIndex);
        this.cardsDeck.remove(randomIndex);
        return retrievedCard;
    }
}