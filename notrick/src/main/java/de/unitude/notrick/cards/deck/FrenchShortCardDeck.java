package de.unitude.notrick.cards.deck;

import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.Color;
import de.unitude.notrick.cards.card.type.FrenchType;
import de.unitude.notrick.cards.card.type.Type;

public class FrenchShortCardDeck extends StandardCardDeck {

    private static final int DECKSIZE = 32;

    public FrenchShortCardDeck() {
	super(DECKSIZE);
    }

    @Override
    protected void init() {
	for (FrenchColor color : FrenchColor.values()) {
	    for (FrenchType type : FrenchType.values()) {
		if (type.getPriority() < FrenchType.SIX.getPriority()) {
		    cards.add(new Card(color, type));
		}
	    }
	}
	iterator = cards.iterator();
    }

    @Override
    public List<? extends Type> getTypes() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<? extends Color> getColors() {
	// TODO Auto-generated method stub
	return null;
    }
}
