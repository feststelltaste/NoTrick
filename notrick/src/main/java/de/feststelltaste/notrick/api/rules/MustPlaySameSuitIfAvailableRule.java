package de.feststelltaste.notrick.api.rules;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.SuitInspector;
import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.card.suit.SuitFilter;
import de.feststelltaste.notrick.api.table.CardTable;

public class MustPlaySameSuitIfAvailableRule implements Rule {

    private List<Card> cardsOnHand;

    public MustPlaySameSuitIfAvailableRule(List<Card> cardsOnHand) {
	this.cardsOnHand = cardsOnHand;
    }

    @Override
    public List<Card> getPlayableCards(CardTable cardTable) {
	List<Card> playableCards = null;

	List<Card> cardsOnTable = cardTable.allCards();

	if (isCardAlreadyPlayed(cardsOnTable)) {
	    Suit suitThatsOnTable = suitOfFirstPlayedCard(cardTable);
	    if (isSuitOnHand(suitThatsOnTable)) {
		playableCards = cardsOfSameSuit(suitThatsOnTable);
	    } else {
		playableCards = allCardsOnHand();
	    }
	} else {
	    playableCards = allCardsOnHand();
	}

	return playableCards;
    }

    private boolean isCardAlreadyPlayed(List<Card> cardsOnTable) {
	return cardsOnTable != null && !cardsOnTable.isEmpty();
    }

    private Suit suitOfFirstPlayedCard(CardTable cardTable) {
	return cardTable.card(0).getSuit();
    }

    private List<Card> cardsOfSameSuit(Suit suitOnTable) {
	return SuitFilter.same(suitOnTable, cardsOnHand);
    }

    private boolean isSuitOnHand(Suit suitOfFirstCard) {
	return SuitInspector.hasSuit(suitOfFirstCard, cardsOnHand);
    }

    private List<Card> allCardsOnHand() {
	return cardsOnHand;
    }
}
