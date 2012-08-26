package de.feststelltaste.notrick.api.cards.card.suit;

import de.feststelltaste.notrick.api.cards.card.CardSet;

public class SuitInspector {

    public static boolean hasSuit(Suit suit, CardSet cardsOnHand) {
	return !SuitFilter.same(suit, cardsOnHand).isEmpty();
    }

}
