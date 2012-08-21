package de.unitude.notrick.table;

import java.util.ArrayList;
import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.CardNonExistingException;
import de.unitude.notrick.cards.card.color.DifferentCardColorsException;
import de.unitude.notrick.cards.card.type.Type;

public class CardTable {

    private List<Card> cardsOnTable = new ArrayList<Card>();

    private Class<? extends Type> cardSetType;

    public void add(Card card) {
	checkCard(card);
	cardsOnTable.add(card);
    }

    private void checkCard(Card card) {
	if (card == null) {
	    throw new CardNonExistingException();
	} else if (!isFromSameCardType(card)) {
	    throw new DifferentCardColorsException();
	}
    }

    private boolean isFromSameCardType(Card card) {
	if (cardSetType == null) {
	    cardSetType = card.getType().getClass();
	}
	return cardSetType.isInstance(card.getType());
    }

    public List<Card> allCards() {
	return cardsOnTable;
    }

    public Card card(int position) {
	if (position >= cardsOnTable.size())
	    throw new CardNonExistingException();

	return cardsOnTable.get(position);
    }

}
