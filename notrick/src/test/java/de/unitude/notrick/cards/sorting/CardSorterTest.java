package de.unitude.notrick.cards.sorting;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.GermanColor;
import de.unitude.notrick.cards.card.type.GermanType;
import de.unitude.notrick.cards.sorting.CardSorter;

public class CardSorterTest {
	
	Card highestCard = new Card(GermanColor.EICHEL, GermanType.ASS);
	Card secondHighestCard = new Card(GermanColor.EICHEL, GermanType.ZEHNER);
	

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCollectionsSort(){
		List<Card> cards = new ArrayList<Card>();
		cards.add(secondHighestCard);
		cards.add(highestCard);
		
		CardSorter.sortLowestPriorityFirst(cards);
		
		assertEquals(highestCard, cards.get(0));
		assertEquals(secondHighestCard, cards.get(1));
	}

}
