package de.unitude.notrick.cards.deck;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.suit.FrenchSuit;
import de.unitude.notrick.cards.card.type.FrenchType;

public class FrenchShortCardDeck extends StandardCardDeck {

    private static final int DECKSIZE = 32;

    public FrenchShortCardDeck() {
	super(DECKSIZE);
    }

    @Override
    protected void init() {
	for (FrenchSuit suit : FrenchSuit.values()) {
	    for (FrenchType type : FrenchType.values()) {
		if (type.getPriority() < FrenchType.SIX.getPriority()) {
		    cards.add(new Card(suit, type));
		}
	    }
	}
	iterator = cards.iterator();
    }

    @Override
    public int numberOfTypes() {
	return DECKSIZE / numberOfSuits();
    }

    @Override
    public int numberOfSuits() {
	return FrenchSuit.values().length;
    }

}
