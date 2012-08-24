package de.feststelltaste.notrick.api.cards.sorting;

import java.util.Collections;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;

public class CardSorter {

    private CardSorter() {
    };

    public static void sortLowestPriorityFirst(List<Card> cards) {
	Collections.sort(cards, Collections.reverseOrder(new PriorityCardComparator()));
    }

}
