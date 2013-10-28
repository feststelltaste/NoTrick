package de.feststelltaste.notrick.api.cards.deck;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

public class FrenchCardDeck extends StandardCardDeck {

    public FrenchCardDeck() {
	super(FrenchType.values().length * FrenchSuit.values().length);
    }

    @Override
    protected void init() {
	for (FrenchSuit suit : FrenchSuit.values()) {
	    for (FrenchType type : FrenchType.values()) {
		super.cards.add(new Card(suit, type));
	    }
	}
    }

    @Override
    public int numberOfTypes() {
	return FrenchType.values().length;
    }

    @Override
    public int numberOfSuits() {
	return FrenchSuit.values().length;
    }

}
