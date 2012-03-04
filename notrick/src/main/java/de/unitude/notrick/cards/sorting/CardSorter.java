package de.unitude.notrick.cards.sorting;

import java.util.Collections;
import java.util.List;

import de.unitude.notrick.cards.card.Card;

public class CardSorter {

    public static void sortLowestPriorityFirst(List<Card> cards) {
	Collections.sort(cards,
		Collections.reverseOrder(new PriorityCardComparator()));
    }

}
