package de.feststelltaste.notrick.api.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.DifferentCardSuitException;
import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.card.suit.SuitFilter;
import de.feststelltaste.notrick.api.cards.sorting.PriorityCardComparator;

public class MustBeCardTypeNeighbour implements Rule {

    @Override
    public List<Card> getPlayableCards(List<Card> cardsOnTable, List<Card> cardsToFilter) {

	List<Card> playableCards;

	if (!isExistingCardRow(cardsOnTable)) {
	    playableCards = cardsToFilter;
	} else {
	    playableCards = getNeigbours(cardsOnTable, cardsToFilter);
	}

	return playableCards;
    }

    private boolean isExistingCardRow(List<Card> cardRow) {
	return cardRow != null && !cardRow.isEmpty();
    }

    private List<Card> getNeigbours(List<Card> cardRow, List<Card> cardsOnHand) {
	List<Card> neighbours;

	Suit currentSuit = suitOfRow(cardRow);
	List<Card> cardsWithSameSuit = SuitFilter.same(currentSuit, cardsOnHand);
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
