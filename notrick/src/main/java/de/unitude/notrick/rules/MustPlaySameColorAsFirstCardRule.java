package de.unitude.notrick.rules;

import java.util.ArrayList;
import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.CardColorUtils;
import de.unitude.notrick.cards.card.color.Color;
import de.unitude.notrick.table.CardTable;

public class MustPlaySameColorAsFirstCardRule implements Rule {

    private List<Card> cardsOnHand;
    private CardColorUtils cardColorUtils = new CardColorUtils();

    public MustPlaySameColorAsFirstCardRule(List<Card> cardsOnHand) {
	this.cardsOnHand = cardsOnHand;
    }

    @Override
    public List<Card> getPlayableCards(CardTable cardTable) {
	List<Card> playableCards = new ArrayList<Card>();

	List<Card> cardsOnTable = cardTable.get();

	if (isFirstCard(cardsOnTable)) {
	    playableCards = cardsOnHand;
	} else {
	    Color colorOfFirstCard = cardsOnTable.get(0).getColor();

	    if (!cardColorUtils
		    .hasCurrentColor(colorOfFirstCard, playableCards)) {
		playableCards = cardsOnHand;
	    } else {
		playableCards = cardColorUtils.filterCardsByColor(
			colorOfFirstCard, cardsOnHand);
	    }
	}

	return playableCards;
    }

    private boolean isFirstCard(List<Card> cardsOnTable) {
	return cardsOnTable == null || cardsOnTable.isEmpty();
    }

}
