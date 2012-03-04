package de.unitude.notrick.cards.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.GermanColor;
import de.unitude.notrick.cards.card.type.GermanType;

public class PriorityCardComparatorTest {

    Card highestCard = new Card(GermanColor.EICHEL, GermanType.ASS);
    Card secondHighestCard = new Card(GermanColor.EICHEL, GermanType.ZEHNER);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCompare() {
	PriorityCardComparator comparator = new PriorityCardComparator();
	assertEquals(1, comparator.compare(highestCard, secondHighestCard));
    }

}
