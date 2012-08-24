package de.unitude.notrick.cards.card;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unitude.notrick.cards.card.suit.FrenchSuit;
import de.unitude.notrick.cards.card.type.FrenchType;

public class CardTest {

    @Test
    public void testGetName() {
	Card c = new Card(FrenchSuit.CLUB, FrenchType.ACE);
	assertEquals(0, c.getSuit().getPriority());
	assertEquals(0, c.getType().getPriority());
    }

}
