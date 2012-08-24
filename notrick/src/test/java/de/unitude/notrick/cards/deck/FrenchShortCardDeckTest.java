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
	assertEquals(FrenchType.ACE, cardDeck.nextCard().getType());
	assertEquals(FrenchType.KING, cardDeck.nextCard().getType());
	assertEquals(FrenchSuit.CLUB, cardDeck.nextCard().getSuit());
	cardDeck.nextCard();
	cardDeck.nextCard();
	cardDeck.nextCard();
	cardDeck.nextCard();
	cardDeck.nextCard();
	assertEquals(FrenchSuit.DIAMOND, cardDeck.nextCard().getSuit());
    }
}
