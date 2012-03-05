package de.unitude.notrick.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.CardColorUtils;
import de.unitude.notrick.cards.card.color.Color;
import de.unitude.notrick.cards.card.color.DifferentCardColorsException;
import de.unitude.notrick.cards.sorting.PriorityCardComparator;
import de.unitude.notrick.table.CardTable;
import de.unitude.notrick.table.MatrixCardTable;

public class MustBeCardTypeNeighbour implements Rule {

    private List<Card> cardsOnHand;
    private CardColorUtils cardColorUtils = new CardColorUtils();

    public MustBeCardTypeNeighbour(List<Card> cardsOnHand) {
	this.cardsOnHand = cardsOnHand;
    }

    @Override
    public List<Card> getPlayableCards(CardTable c) {
	List<Card> playableCards;
	if (c instanceof MatrixCardTable) {
	    MatrixCardTable m = (MatrixCardTable) c;
	    playableCards = filterMatrixCardTable(m);
	} else {
	    playableCards = filterCardTable(c);
	}
	return playableCards;
    }

    private List<Card> filterMatrixCardTable(MatrixCardTable m) {
	return null;
    }

    private List<Card> filterCardTable(CardTable c) {
	List<Card> cardRow = c.get();

	List<Card> playableCards;

	if (!isExistingCardRow(cardRow)) {
	    playableCards = cardsOnHand;
	} else {
	    playableCards = getNeigbours(cardRow);
	}

	return playableCards;
    }

    private boolean isExistingCardRow(List<Card> cardRow) {
	boolean isExistingCardRow = cardRow != null && !cardRow.isEmpty();
	return isExistingCardRow;
    }

    private List<Card> getNeigbours(List<Card> cardRow) {
	List<Card> neighbours;

	Color currentColor = colorOfRow(cardRow);
	List<Card> cardsWithSameColor = cardColorUtils.filterCardsByColor(
		currentColor, this.cardsOnHand);
	if (cardsWithSameColor.isEmpty()) {
	    neighbours = new ArrayList<Card>();
	} else {

	    Collections.sort(cardRow, new PriorityCardComparator());
	    int highestCardTypePriority = cardRow.get(0).getType()
		    .getPriority();
	    int lowestCardTypeOfRow = cardRow.get(cardRow.size() - 1).getType()
		    .getPriority();

	    neighbours = getImmediateNeighbours(cardsWithSameColor,
		    highestCardTypePriority, lowestCardTypeOfRow);

	}

	return neighbours;

    }

    List<Card> getImmediateNeighbours(List<Card> cardsWithSameColor,
	    int highestPriority, int lowestPriority) {
	List<Card> immediateNeighbours = new ArrayList<Card>(2);

	Card lowestNeighbour = null;
	Card highestNeighbour = null;
	for (Card c : cardsWithSameColor) {
	    int prio = c.getType().getPriority();

	    if (prio - 1 == highestPriority) {
		highestNeighbour = c;
	    } else if (prio + 1 == lowestPriority) {
		lowestNeighbour = c;
	    } else {
		continue;
	    }
	}

	if (lowestNeighbour != null)
	    immediateNeighbours.add(lowestNeighbour);
	if (highestNeighbour != null)
	    immediateNeighbours.add(highestNeighbour);

	return immediateNeighbours;
    }

    Color colorOfRow(List<Card> cards) {
	Color colorOfFirstCard = cards.get(0).getColor();
	for (Card card : cards) {
	    if (card.getColor() != colorOfFirstCard) {
		throw new DifferentCardColorsException();
	    }
	}
	return colorOfFirstCard;
    }

}
