package de.unitude.notrick.cards.deck;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.suit.GermanSuit;
import de.unitude.notrick.cards.card.type.GermanType;

public class GermanCardDeck extends StandardCardDeck {

    private static final int DECK_SIZE = 32;

    public GermanCardDeck() {
	super(DECK_SIZE);
    }

    @Override
    protected void init() {
	for (GermanSuit suit : GermanSuit.values()) {
	    for (GermanType type : GermanType.values()) {
		cards.add(new Card(suit, type));
	    }
	}
    }

    @Override
    public int numberOfTypes() {
	return GermanType.values().length;
    }

    @Override
    public int numberOfSuits() {
	return GermanSuit.values().length;
    }

}
