package de.unitude.notrick.rules;

import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.CardColorUtils;
import de.unitude.notrick.cards.card.color.Color;
import de.unitude.notrick.table.CardTable;

public class MustPlaySameColorIfAvailableRule implements Rule {

    private List<Card> cardsOnHand;
    private CardColorUtils cardColorUtils = new CardColorUtils();

    public MustPlaySameColorIfAvailableRule(List<Card> cardsOnHand) {
	this.cardsOnHand = cardsOnHand;
    }

    @Override
    public List<Card> getPlayableCards(CardTable cardTable) {
	List<Card> playableCards = null;

	List<Card> cardsOnTable = cardTable.allCards();

	if (isCardAlreadyPlayed(cardsOnTable)) {
	    Color colorThatsOnTable = colorOfFirstPlayedCard(cardTable);
	    if (isColorOnHand(colorThatsOnTable)) {
		playableCards = cardsOfSameColor(colorThatsOnTable);
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

    private Color colorOfFirstPlayedCard(CardTable cardTable) {
	return cardTable.card(0).getColor();
    }
    
    private List<Card> cardsOfSameColor(Color colorOnTable) {
	return cardColorUtils.filterCardsByColor(colorOnTable,
		cardsOnHand);
    }

    private boolean isColorOnHand(Color colorOfFirstCard) {
	return cardColorUtils.hasCurrentColor(colorOfFirstCard, cardsOnHand);
    }

    private List<Card> allCardsOnHand() {
	return cardsOnHand;
    }
}
