package de.feststelltaste.notrick.api.cards.card.suit;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;

public class CardSuitUtils {

    public static boolean hasCurrentSuit(Suit suit, List<Card> cards) {
	return !SuitFilter.same(suit, cards).isEmpty();
    }

}
