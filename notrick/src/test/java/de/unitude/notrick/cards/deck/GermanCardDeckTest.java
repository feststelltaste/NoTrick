package de.unitude.notrick.cards.deck;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.GermanColor;
import de.unitude.notrick.cards.card.type.GermanType;
import de.unitude.notrick.cards.deck.CardDeck;
import de.unitude.notrick.cards.deck.GermanCardDeck;
import de.unitude.notrick.cards.sorting.PriorityCardComparator;

public class GermanCardDeckTest {

	CardDeck cardDeck;

	@Before
	public void setUp() throws Exception {
		cardDeck = new GermanCardDeck();
	}

	@Test
	public void testInitSomeCards() {
		assertEquals(GermanType.ASS, cardDeck.nextCard().getType());
		assertEquals(GermanType.ZEHNER, cardDeck.nextCard().getType());
		assertEquals(GermanColor.EICHEL, cardDeck.nextCard().getColor());
		cardDeck.nextCard();
		cardDeck.nextCard();
		cardDeck.nextCard();
		cardDeck.nextCard();
		cardDeck.nextCard();
		assertEquals(GermanColor.GRUEN, cardDeck.nextCard().getColor());
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
