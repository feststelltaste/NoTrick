package de.unitude.notrick.cards.deck;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.suit.GermanSuit;
import de.unitude.notrick.cards.card.type.GermanType;

public class GermanCardDeckTest extends StandardCardDeckTest{

    @Before
    public void setUp() throws Exception {
	cardDeck = new GermanCardDeck();
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
