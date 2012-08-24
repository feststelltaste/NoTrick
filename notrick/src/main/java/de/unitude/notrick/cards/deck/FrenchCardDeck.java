package de.unitude.notrick.cards.deck;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.suit.FrenchSuit;
import de.unitude.notrick.cards.card.type.FrenchType;

public class FrenchCardDeck extends StandardCardDeck {

    public FrenchCardDeck() {
	super(FrenchType.values().length * FrenchSuit.values().length);
    }

    @Override
    protected void init() {
	for (FrenchSuit suit : FrenchSuit.values()) {
	    for (FrenchType type : FrenchType.values()) {
		cards.add(new Card(suit, type));
	    }
	}
	iterator = cards.iterator();
    }

    @Override
    public int numberOfTypes() {
	return FrenchSuit.values().length;
    }

    @Override
    public int numberOfSuits() {
	return FrenchSuit.values().length;
    }

}
