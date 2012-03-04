package de.unitude.notrick.cards.card;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unitude.notrick.cards.card.type.FrenchType;
import de.unitude.notrick.cards.deck.FrenchColor;

public class CardTest {

	@Test
	public void testGetName() {
		Card c = new Card(FrenchColor.CLUB, FrenchType.ACE);
		assertEquals(0, c.getColor().getPriority());
		assertEquals(0, c.getType().getPriority());
	}

}
