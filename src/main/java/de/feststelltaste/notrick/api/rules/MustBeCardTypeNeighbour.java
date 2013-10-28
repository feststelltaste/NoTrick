package de.feststelltaste.notrick.api.rules;

import java.util.Collections;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.suit.DifferentCardSuitException;
import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.sorting.PriorityCardComparator;

public class MustBeCardTypeNeighbour implements Rule {

    @Override
    public CardSet getPlayableCards(CardSet cardsOnTable, CardSet cardsToFilter) {

	CardSet playableCards;

	if (!isExistingCardRow(cardsOnTable)) {
	    playableCards = cardsToFilter;
	} else {
	    playableCards = getNeigbours(cardsOnTable, cardsToFilter);
	}

	return playableCards;
    }

    private boolean isExistingCardRow(CardSet cardsOnTable) {
	return cardsOnTable != null && !cardsOnTable.isEmpty();
    }

    private CardSet getNeigbours(CardSet cardsOnTable, CardSet cardsToFilter) {
	CardSet neighbours;

	Suit currentSuit = suitOfRow(cardsOnTable);
	CardSet cardsWithSameSuit = cardsToFilter.filter(currentSuit);
	if (cardsWithSameSuit.isEmpty()) {
	    neighbours = new CardSet();
	} else {

	    Collections.sort(cardsOnTable.asList(), new PriorityCardComparator());
	    int highestCardTypePriority = cardsOnTable.asList().get(0).getType().getPriority();
	    int lowestCardTypeOfRow = cardsOnTable.asList().get(cardsOnTable.size() - 1).getType().getPriority();

	    neighbours = getImmediateNeighbours(cardsWithSameSuit, highestCardTypePriority, lowestCardTypeOfRow);

	}

	return neighbours;

    }

    protected CardSet getImmediateNeighbours(CardSet cardsWithSameSuit, int highestPriority, int lowestPriority) {
	CardSet immediateNeighbours = new CardSet();

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

    private Suit suitOfRow(CardSet cardsOnTable) {
	Suit suitOfFirstCard = cardsOnTable.asList().get(0).getSuit();
	for (Card card : cardsOnTable) {
	    if (card.getSuit() != suitOfFirstCard) {
		throw new DifferentCardSuitException();
	    }
	}
	return suitOfFirstCard;
    }

}
