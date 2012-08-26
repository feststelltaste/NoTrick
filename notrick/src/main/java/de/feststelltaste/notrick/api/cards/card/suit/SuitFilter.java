package de.feststelltaste.notrick.api.cards.card.suit;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public class SuitFilter {

    public static CardSet same(Suit suit, CardSet cardsOnHand) {
	CardSet cardsWithSuit = new CardSet();

	for (Card card : cardsOnHand) {
	    if (card.getSuit() == suit) {
		cardsWithSuit.add(card);
	    }
	}

	return cardsWithSuit;
    }

}
