package de.feststelltaste.notrick.api.cards.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

public class PriorityCardComparatorTest {

    Card highestCard = new Card(GermanSuit.EICHEL, GermanType.ASS);
    Card secondHighestCard = new Card(GermanSuit.EICHEL, GermanType.ZEHNER);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCompare() {
        PriorityCardComparator comparator = new PriorityCardComparator();
        assertEquals(1, comparator.compare(highestCard, secondHighestCard));
    }

}
