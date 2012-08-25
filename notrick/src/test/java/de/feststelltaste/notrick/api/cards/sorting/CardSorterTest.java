package de.feststelltaste.notrick.api.cards.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

public class CardSorterTest {

    Card highestCard = new Card(GermanSuit.EICHEL, GermanType.ASS);
    Card secondHighestCard = new Card(GermanSuit.EICHEL, GermanType.ZEHNER);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCollectionsSort() {
	CardSet cards = new CardSet();
	cards.add(secondHighestCard);
	cards.add(highestCard);

	cards = CardSorter.sortLowestPriorityFirst(cards);
	assertEquals(highestCard, cards.asList().get(0));
	assertEquals(secondHighestCard, cards.asList().get(1));
    }

}
