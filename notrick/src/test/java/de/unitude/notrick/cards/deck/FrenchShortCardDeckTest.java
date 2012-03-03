package de.unitude.notrick.cards.deck;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.type.FrenchType;
import de.unitude.notrick.cards.sorting.PriorityCardComparator;

public class FrenchShortCardDeckTest {

	CardDeck cardDeck;

	@Before
	public void setUp() throws Exception {
		cardDeck = new FrenchShortCardDeck();
	}

	@Test
	public void testInitSomeCards() {
		assertEquals(FrenchType.ACE, cardDeck.nextCard().getType());
		assertEquals(FrenchType.KING, cardDeck.nextCard().getType());
		assertEquals(FrenchColor.CLUB, cardDeck.nextCard().getColor());
		cardDeck.nextCard();
		cardDeck.nextCard();
		cardDeck.nextCard();
		cardDeck.nextCard();
		cardDeck.nextCard();
		assertEquals(FrenchColor.DIAMOND, cardDeck.nextCard().getColor());
	}

	@Test
	public void testInitCardDeckConsistency() {

		int i = 0;
		int color = 0;
		int type = 0;

		while (cardDeck.hasCards()) {
			Card c = cardDeck.nextCard();
			color = i / 8;
			type = i % 8;
			assertEquals(color, c.getColor().getPriority());
			assertEquals(type, c.getType().getPriority());
			i++;
		}
	}

	@Test
	public void testInitCardDeckOrderingWithComparator() {
		PriorityCardComparator comparator = new PriorityCardComparator();
		Card formerCard = cardDeck.nextCard();
		while (cardDeck.hasCards()) {
			Card currentCard = cardDeck.nextCard();
			assertEquals(1, comparator.compare(formerCard, currentCard));
			formerCard = currentCard;
		}
	}
}
