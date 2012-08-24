package de.unitude.notrick.cards.deck;

import java.util.Arrays;
import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.suit.GermanSuit;
import de.unitude.notrick.cards.card.suit.Suit;
import de.unitude.notrick.cards.card.type.GermanType;
import de.unitude.notrick.cards.card.type.Type;

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
    public List<? extends Type> getTypes() {
	return Arrays.asList(GermanType.values());
    }

    @Override
    public List<? extends Suit> getSuits() {
	return Arrays.asList(GermanSuit.values());
    }

}
