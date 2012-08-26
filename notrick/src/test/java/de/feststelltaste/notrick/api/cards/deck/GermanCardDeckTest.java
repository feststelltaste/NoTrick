package de.feststelltaste.notrick.api.cards.deck;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

public class GermanCardDeckTest extends StandardCardDeckTest {

    @Before
    public void setUp() throws Exception {
	super.cardDeck = new GermanCardDeck();
    }

    @Test
    public void testInitSomeCards() {
	assertEquals(GermanType.ASS, super.cardDeck.nextCard().getType());
	assertEquals(GermanType.ZEHNER, super.cardDeck.nextCard().getType());
	assertEquals(GermanSuit.EICHEL, super.cardDeck.nextCard().getSuit());
	super.cardDeck.nextCard();
	super.cardDeck.nextCard();
	super.cardDeck.nextCard();
	super.cardDeck.nextCard();
	super.cardDeck.nextCard();
	assertEquals(GermanSuit.GRUEN, super.cardDeck.nextCard().getSuit());
    }
}
