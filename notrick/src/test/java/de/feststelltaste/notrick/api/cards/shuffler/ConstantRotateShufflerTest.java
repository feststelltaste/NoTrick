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
package de.feststelltaste.notrick.api.cards.shuffler;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.deck.GermanCardDeck;
import de.feststelltaste.notrick.api.cards.shuffle.ConstantRotateShuffler;
import de.feststelltaste.notrick.api.cards.shuffle.Shuffler;

public class ConstantRotateShufflerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testRandomShuffler() {
	GermanCardDeck g = new GermanCardDeck();
	Shuffler r = new ConstantRotateShuffler(g);
	r.shuffleCards();
	assertEquals(GermanSuit.GRUEN, g.nextCard().getSuit());
    }

}
