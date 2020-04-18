package com.avatarduel.model.attribute;

import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Collections;

import com.avatarduel.model.Card;
import com.avatarduel.model.Character;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.model.type.Element;
import com.avatarduel.reader.CharacterReader;
import com.avatarduel.reader.LandReader;
import com.avatarduel.reader.SkillReader;

public class Deck {
    protected Stack<Card> cardsDeck;

    public Deck() {
        this.cardsDeck = new Stack<Card>();
        this.fillInCards();
        this.shuffle();
    }

    public Deck(Stack<Card> cardsDeck){
        this.cardsDeck = cardsDeck;
        this.shuffle();
    }

    private void fillInCards() {

        // Get List of card
        CharacterReader charRead = new CharacterReader();
        LandReader landRead = new LandReader();
        SkillReader skillRead = new SkillReader();
        List<Character> listChar = charRead.getCharacterList();
        List<Land> listLand = landRead.getLandList();
        List<Skill> listSkill = skillRead.getSkillList();
        try {
            charRead.loadCards();
            landRead.loadCards();
            skillRead.loadCards();
        }
        catch (Exception exc) {
            // do something about it
        }

        // Add cards randomly
        // Cards proportion in a deck (75) :
        // Number of Land Cards (24) : EARTH(6), AIR(6), WATER(6), FIRE(6), ENERGY(6)
        // Number of Character Cards (24) : EARTH(6), AIR(6), WATER(6), FIRE(6), ENERGY(6)
        // Number of Skill Cards (12) : EARTH(3), AIR(3), WATER(3), FIRE(3), ENERGY(3)
        this.insertCardToDeckBasedOnCategory(listChar, "Character", false);
        this.insertCardToDeckBasedOnCategory(listLand, "Land", true);
        this.insertCardToDeckBasedOnCategory(listSkill, "Skill", false);
    }

    private void insertCardToDeckBasedOnCategory(List<? extends Card> listCard, String category, boolean allowDouble) {
        Random random = new Random();
        int nEarth = 0;
        int nWater = 0;
        int nFire = 0;
        int nAir = 0;
        int nEnergy = 0;
        int randIdx, maxCard, maxElmt;
        if (category.equals("Character")) {
            maxCard = 30;
            maxElmt = 6;
        }
        else if (category.equals("Land")) {
            maxCard = 60;
            maxElmt = 6;
        }
        else {
            maxCard = 75;
            maxElmt = 3;
        }
        while (this.cardsDeck.size() < maxCard) {
            randIdx = Math.abs(random.nextInt(listCard.size()));
            if (listCard.get(randIdx).getElement() == Element.AIR) {
                if (nAir < maxElmt) {
                    this.cardsDeck.add(listCard.get(randIdx));
                    nAir++;
                }
            }
            else if (listCard.get(randIdx).getElement() == Element.FIRE)  {
                if (nFire < maxElmt) {
                    this.cardsDeck.add(listCard.get(randIdx));
                    nFire++;
                }
            }
            else if (listCard.get(randIdx).getElement() == Element.WATER) {
                if (nWater < maxElmt) {
                    this.cardsDeck.add(listCard.get(randIdx));
                    nWater++;
                }
            }
            else if (listCard.get(randIdx).getElement() == Element.EARTH) {
                if (nEarth < maxElmt) {
                    this.cardsDeck.add(listCard.get(randIdx));
                    nEarth++;
                }
            } else {
                if(nEnergy < maxElmt) {
                    this.cardsDeck.add(listCard.get(randIdx));
                    nEnergy++;
                }
            }
            if (!allowDouble) {
                listCard.remove(randIdx);
            }
        }
    }

    public Card draw() {
        return this.cardsDeck.pop();
    }

    public void shuffle() {
        Collections.shuffle(this.cardsDeck);
    }
}

