package de.feststelltaste.notrick.api.table;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardNonExistingException;
import de.feststelltaste.notrick.api.cards.card.suit.DifferentCardSuitException;
import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

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
	    c.add(new Card(FrenchSuit.CLUB, FrenchType.ACE));
	    c.add(new Card(GermanSuit.GRUEN, GermanType.ASS));
	    fail();
	} catch (DifferentCardSuitException e) {
	    // expected
	}
    }

    @Test
    public void testAdd() {
	Card frenchClubAce = new Card(FrenchSuit.CLUB, FrenchType.ACE);
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
