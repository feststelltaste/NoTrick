package de.feststelltaste.notrick.api.cards.deck;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.suit.TestSuit;
import de.feststelltaste.notrick.api.cards.card.suit.TestType;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

public class TestCardDeck extends StandardCardDeck {

    public TestCardDeck() {
	super(TestType.values().length+TestSuit.values().length);
    }

    @Override
    public int numberOfTypes() {
	return TestType.values().length;
    }

    @Override
    public int numberOfSuits() {
	return TestSuit.values().length;
    }

    @Override
    protected void init() {
	for (TestSuit suit : TestSuit.values()) {
	    for (TestType type : TestType.values()) {
		super.cards.add(new Card(suit, type));
	    }
	}
    }
    

}
