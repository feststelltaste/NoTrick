package de.feststelltaste.notrick.api.cards.card.suit;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;

public class SuitInspector {

    public static boolean hasSuit(Suit suit, List<Card> cards) {
	return !SuitFilter.same(suit, cards).isEmpty();
    }

}
