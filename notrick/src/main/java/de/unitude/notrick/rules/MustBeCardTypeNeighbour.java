package de.unitude.notrick.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.suit.CardSuitUtils;
import de.unitude.notrick.cards.card.suit.DifferentCardSuitException;
import de.unitude.notrick.cards.card.suit.Suit;
import de.unitude.notrick.cards.sorting.PriorityCardComparator;
import de.unitude.notrick.table.CardTable;

public class MustBeCardTypeNeighbour implements Rule {

    private List<Card> cardsOnHand;

    public MustBeCardTypeNeighbour(List<Card> cardsOnHand) {
	this.cardsOnHand = cardsOnHand;
    }

    @Override
    public List<Card> getPlayableCards(CardTable cardTable) {

	List<Card> playableCards;

	List<Card> cardRow = cardTable.allCards();

	if (!isExistingCardRow(cardRow)) {
	    playableCards = cardsOnHand;
	} else {
	    playableCards = getNeigbours(cardRow);
	}

	return playableCards;
    }

    private boolean isExistingCardRow(List<Card> cardRow) {
	return cardRow != null && !cardRow.isEmpty();
    }

    private List<Card> getNeigbours(List<Card> cardRow) {
	List<Card> neighbours;

	Suit currentSuit = suitOfRow(cardRow);
	List<Card> cardsWithSameSuit = CardSuitUtils.filterCardsBySuit(currentSuit, this.cardsOnHand);
	if (cardsWithSameSuit.isEmpty()) {
	    neighbours = new ArrayList<Card>();
	} else {

	    Collections.sort(cardRow, new PriorityCardComparator());
	    int highestCardTypePriority = cardRow.get(0).getType().getPriority();
	    int lowestCardTypeOfRow = cardRow.get(cardRow.size() - 1).getType().getPriority();

	    neighbours = getImmediateNeighbours(cardsWithSameSuit, highestCardTypePriority, lowestCardTypeOfRow);

	}

	return neighbours;

    }

    List<Card> getImmediateNeighbours(List<Card> cardsWithSameSuit, int highestPriority, int lowestPriority) {
	List<Card> immediateNeighbours = new ArrayList<Card>(2);

	Card lowestNeighbour = null;
	Card highestNeighbour = null;
	for (Card c : cardsWithSameSuit) {
	    int prio = c.getType().getPriority();

	    if (prio - 1 == highestPriority) {
		highestNeighbour = c;
	    } else if (prio + 1 == lowestPriority) {
		lowestNeighbour = c;
	    } else {
		continue;
	    }
	}

	if (lowestNeighbour != null) {
	    immediateNeighbours.add(lowestNeighbour);
	}
	if (highestNeighbour != null) {
	    immediateNeighbours.add(highestNeighbour);
	}

	return immediateNeighbours;
    }

    private Suit suitOfRow(List<Card> cards) {
	Suit suitOfFirstCard = cards.get(0).getSuit();
	for (Card card : cards) {
	    if (card.getSuit() != suitOfFirstCard) {
		throw new DifferentCardSuitException();
	    }
	}
	return suitOfFirstCard;
    }

}
