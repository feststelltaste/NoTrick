package de.feststelltaste.notrick.api.cards.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

public class LowestPriorityFirstCardSorterTest {

    private Card highestCard = new Card(GermanSuit.EICHEL, GermanType.ASS);
    private Card secondHighestCard = new Card(GermanSuit.EICHEL, GermanType.ZEHNER);
    private CardSortingStrategy sorter;

    @Before
    public void setUp() throws Exception {
        sorter = new LowestPriorityFirstCardSorter();
    }

    @Test
    public void testCollectionsSort() {
        CardSet cards = new CardSet();
        cards.add(secondHighestCard);
        cards.add(highestCard);

        cards = sorter.sort(cards);
        assertEquals(highestCard, cards.asList().get(0));
        assertEquals(secondHighestCard, cards.asList().get(1));
    }

}
