package de.feststelltaste.notrick.api.cards.deck;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

public class GermanCardDeck extends StandardCardDeck {

    public GermanCardDeck() {
	super(GermanType.values().length * GermanSuit.values().length);
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
