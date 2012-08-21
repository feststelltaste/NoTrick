package de.unitude.notrick.table;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.CardNonExistingException;
import de.unitude.notrick.cards.card.color.DifferentCardColorsException;
import de.unitude.notrick.cards.card.color.GermanColor;
import de.unitude.notrick.cards.card.type.FrenchType;
import de.unitude.notrick.cards.card.type.GermanType;
import de.unitude.notrick.cards.deck.FrenchColor;

public class CardTableTest {

    CardTable c;

    @Before
    public void setUp() throws Exception {
	c = new CardTable();
    }

    @Test
    public void testAddNull() {
	try {
	    c.add(null);
	    fail();
	} catch (CardNonExistingException e) {
	    // expected
	}
    }

    @Test
    public void testAddDifferentCardSetTypes() {
	try {
	    c.add(new Card(FrenchColor.CLUB, FrenchType.ACE));
	    c.add(new Card(GermanColor.GRUEN, GermanType.ASS));
	    fail();
	} catch (DifferentCardColorsException e) {
	    // expected
	}
    }

    @Test
    public void testAdd() {
	Card frenchClubAce = new Card(FrenchColor.CLUB, FrenchType.ACE);
	c.add(frenchClubAce);
	assertEquals(frenchClubAce, c.card(0));
    }

    @Test
    public void testAllCardsWithEmpty() {
	assertNotNull(c.allCards());
	assertTrue(c.allCards().isEmpty());
    }

    @Test
    public void testCardNonExising() {
	try {
	    c.card(0);
	} catch (CardNonExistingException e) {
	    // expected
	}
    }

}
