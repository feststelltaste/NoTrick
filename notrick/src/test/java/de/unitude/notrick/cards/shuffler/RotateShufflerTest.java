/**
 * update test bla
 * test2
 */
/**
 * update test run
 */
/**
 * test
 */
package de.unitude.notrick.cards.shuffler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.color.GermanColor;
import de.unitude.notrick.cards.deck.GermanCardDeck;
import de.unitude.notrick.cards.shuffle.RotateShuffler;
import de.unitude.notrick.cards.shuffle.Shuffler;

public class RotateShufflerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRandomShuffler() {
		GermanCardDeck g = new GermanCardDeck();
		Shuffler r = new RotateShuffler(g);
		r.shuffleCards();
		assertEquals(GermanColor.GRUEN, g.nextCard().getColor());
	}

}
