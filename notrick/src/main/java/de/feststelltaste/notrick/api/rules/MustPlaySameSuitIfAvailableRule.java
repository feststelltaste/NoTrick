package de.feststelltaste.notrick.api.rules;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.card.suit.SuitFilter;
import de.feststelltaste.notrick.api.cards.card.suit.SuitInspector;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.table.CardTable;

public class MustPlaySameSuitIfAvailableRule implements Rule {

    @Override
    public List<Card> getPlayableCards(List<Card> alreadyPlayedCards, List<Card> cards) {
	List<Card> playableCards = cards;

	if (isCardAlreadyPlayed(alreadyPlayedCards)) {
	    Suit suitThatsOnTable = suitOfFirstPlayedCard(alreadyPlayedCards);
	    if (isSuitOnHand(suitThatsOnTable, cards)) {
		playableCards = cardsOfSameSuit(suitThatsOnTable, cards);
	    } 
	}

	return playableCards;
    }

    private boolean isCardAlreadyPlayed(List<Card> cardsOnTable) {
	return cardsOnTable != null && !cardsOnTable.isEmpty();
    }

    private Suit suitOfFirstPlayedCard(List<Card> alreadyPlayedCards) {
	return alreadyPlayedCards.get(0).getSuit();
    }

    private List<Card> cardsOfSameSuit(Suit suitOnTable, List<Card> cardsOnHand) {
	return SuitFilter.same(suitOnTable, cardsOnHand);
    }

    private boolean isSuitOnHand(Suit suitOfFirstCard, List<Card> cardsOnHand) {
	return SuitInspector.hasSuit(suitOfFirstCard, cardsOnHand);
    }

}
