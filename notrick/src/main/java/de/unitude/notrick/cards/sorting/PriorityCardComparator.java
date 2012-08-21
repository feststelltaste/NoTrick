package de.unitude.notrick.cards.sorting;

import java.util.Comparator;

import de.unitude.notrick.cards.card.Card;

public class PriorityCardComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
	if (card1.getColor().getPriority() < card2.getColor().getPriority()) {
	    return 1;
	} else if (card1.getColor().getPriority() == card2.getColor().getPriority()) {
	    if (card1.getType().getPriority() < card2.getType().getPriority()) {
		return 1;
	    } else {
		return -1;
	    }
	} else {
	    return -1;
	}
    }

}
