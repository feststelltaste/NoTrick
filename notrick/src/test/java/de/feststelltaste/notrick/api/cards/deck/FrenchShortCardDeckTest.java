package de.feststelltaste.notrick.api.cards.deck;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;
import de.feststelltaste.notrick.api.cards.deck.FrenchShortCardDeck;

public class FrenchShortCardDeckTest extends StandardCardDeckTest {

    @Before
    public void setUp() throws Exception {
	cardDeck = new FrenchShortCardDeck();
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
