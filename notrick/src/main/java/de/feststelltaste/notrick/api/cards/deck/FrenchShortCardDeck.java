package de.feststelltaste.notrick.api.cards.deck;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

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
