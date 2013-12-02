package de.feststelltaste.notrick.api.cards.sorting;

import java.util.Collections;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public class LowestPriorityFirstCardSorter implements CardSortingStrategy {

    public CardSet sort(CardSet unsortedCardSet) {
        List<Card> cardsAsList = unsortedCardSet.asList();
        Collections.sort(cardsAsList, Collections.reverseOrder(new PriorityCardComparator()));
        return new CardSet(cardsAsList);
    }

}
