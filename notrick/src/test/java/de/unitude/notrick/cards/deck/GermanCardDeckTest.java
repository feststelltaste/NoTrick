package de.unitude.notrick.cards.deck;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.suit.GermanSuit;
import de.unitude.notrick.cards.card.type.GermanType;
import de.unitude.notrick.cards.sorting.PriorityCardComparator;

public class GermanCardDeckTest {

    CardDeck cardDeck;

    @Before
    public void setUp() throws Exception {
	cardDeck = new GermanCardDeck();
    }

    @Test
    public void testInitCardDeckConsistency() {

	int i = 0;
	int suit = 0;
	int type = 0;

	while (cardDeck.hasCards()) {
	    Card c = cardDeck.nextCard();
	    suit = i / 8;
	    type = i % 8;
	    assertEquals(suit, c.getSuit().getPriority());
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

    @Test
    public void testInitSomeCards() {
	assertEquals(GermanType.ASS, cardDeck.nextCard().getType());
	assertEquals(GermanType.ZEHNER, cardDeck.nextCard().getType());
	assertEquals(GermanSuit.EICHEL, cardDeck.nextCard().getSuit());
	cardDeck.nextCard();
	cardDeck.nextCard();
	cardDeck.nextCard();
	cardDeck.nextCard();
	cardDeck.nextCard();
	assertEquals(GermanSuit.GRUEN, cardDeck.nextCard().getSuit());
    }
}
