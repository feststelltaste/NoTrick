package de.unitude.notrick.cards.card;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.GermanColor;
import de.unitude.notrick.cards.card.type.GermanType;

public class CardTest {

	@Test
	public void testGetName() {
		Card c = new Card(GermanColor.HERZ, GermanType.KOENIG);
		assertEquals("Herzkönig", c.getName());
	}

}
