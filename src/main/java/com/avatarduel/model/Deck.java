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
    }

    public void fillInCards() {

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
        this.insertCardToDeckBasedOnCategory(listChar, "Character");
        this.insertCardToDeckBasedOnCategory(listLand, "Land");
        this.insertCardToDeckBasedOnCategory(listSkill, "Skill");
    }

    private void insertCardToDeckBasedOnCategory(List<? extends Card> listCard, String category) {
        Random random = new Random();
        int nEarth = 0;
        int nWater = 0;
        int nFire = 0;
        int nAir = 0;
        int randIdx, maxCard, maxElmt;
        if (category.equals("Character")) {
            maxCard = 24;
            maxElmt = 6;
        }
        else if (category.equals("Land")) {
            maxCard = 48;
            maxElmt = 6;
        }
        else {
            maxCard = 60;
            maxElmt = 3;
        }
        while (this.cardsDeck.size() < maxCard) {
            randIdx = random.nextInt(listCard.size());
            if (listCard.get(randIdx).getElement() == Element.AIR && nAir < maxElmt) {
                this.cardsDeck.add(listCard.get(randIdx));
                listCard.remove(randIdx);
                nAir++;
            }
            else if (listCard.get(randIdx).getElement() == Element.FIRE && nFire < maxElmt) {
                this.cardsDeck.add(listCard.get(randIdx));
                listCard.remove(randIdx);
                nFire++;
            }
            else if (listCard.get(randIdx).getElement() == Element.WATER && nWater < maxElmt) {
                this.cardsDeck.add(listCard.get(randIdx));
                listCard.remove(randIdx);
                nWater++;
            }
            else if (listCard.get(randIdx).getElement() == Element.EARTH && nEarth < maxElmt) {
                this.cardsDeck.add(listCard.get(randIdx));
                listCard.remove(randIdx);
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

