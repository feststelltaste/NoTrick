package de.feststelltaste.notrick.api.rules;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.card.suit.SuitFilter;
import de.feststelltaste.notrick.api.cards.card.suit.SuitInspector;

public class MustPlaySameSuitIfAvailableRule implements Rule {

    @Override
    public CardSet getPlayableCards(CardSet alreadyPlayedCards, CardSet cardsOnHand) {
	CardSet playableCards = cardsOnHand;

	if (isCardAlreadyPlayed(alreadyPlayedCards)) {
	    Suit suitThatsOnTable = suitOfFirstPlayedCard(alreadyPlayedCards);
	    if (isSuitOnHand(suitThatsOnTable, cardsOnHand)) {
		playableCards = cardsOfSameSuit(suitThatsOnTable, cardsOnHand);
	    } 
	}

	return playableCards;
    }

    private boolean isCardAlreadyPlayed(CardSet alreadyPlayedCards) {
	return !alreadyPlayedCards.isEmpty();
    }

    private Suit suitOfFirstPlayedCard(CardSet alreadyPlayedCards) {
	return alreadyPlayedCards.asList().get(0).getSuit();
    }

    private CardSet cardsOfSameSuit(Suit suitOnTable, CardSet cardsOnHand) {
	return SuitFilter.same(suitOnTable, cardsOnHand);
    }

    private boolean isSuitOnHand(Suit suitOfFirstCard, CardSet cardsOnHand) {
	return SuitInspector.hasSuit(suitOfFirstCard, cardsOnHand);
    }

}
