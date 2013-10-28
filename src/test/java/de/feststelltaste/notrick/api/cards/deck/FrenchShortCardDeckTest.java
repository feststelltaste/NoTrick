package de.feststelltaste.notrick.api.cards.deck;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

public class FrenchShortCardDeckTest extends StandardCardDeckTest {

    @Before
    public void setUp() throws Exception {
	super.cardDeck = new FrenchShortCardDeck();
    }

    @Test
    public void testInitSomeCards() {
	assertEquals(FrenchType.ACE, super.cardDeck.nextCard().getType());
	assertEquals(FrenchType.KING, super.cardDeck.nextCard().getType());
	assertEquals(FrenchSuit.CLUB, super.cardDeck.nextCard().getSuit());
	super.cardDeck.nextCard();
	super.cardDeck.nextCard();
	super.cardDeck.nextCard();
	super.cardDeck.nextCard();
	super.cardDeck.nextCard();
	assertEquals(FrenchSuit.DIAMOND, super.cardDeck.nextCard().getSuit());
    }
}
