package de.feststelltaste.notrick.api.cards.sorting;

import java.util.Collections;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public class CardSorter {

    private CardSorter() {
    };

    public static CardSet sortLowestPriorityFirst(CardSet cardSet) {
	List<Card> cardsAsList = cardSet.asList();
	Collections.sort(cardsAsList, Collections.reverseOrder(new PriorityCardComparator()));
	return new CardSet(cardsAsList);
    }

}
