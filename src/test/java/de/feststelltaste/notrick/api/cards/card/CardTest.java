package de.feststelltaste.notrick.api.cards.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

public class CardTest {

    Card card = new Card(FrenchSuit.CLUB, FrenchType.ACE);

    @Test
    public void NullIsNotEqual() {
	assertFalse(card.equals(null));
    }

    @Test
    public void FalseTypeIsNotEqual() {
	assertFalse(card.equals(new Object()));
    }

    @Test
    public void UnequalCardIsNotEqual() {
	assertFalse(card.equals(new Card(FrenchSuit.CLUB, FrenchType.EIGTH)));
    }

    @Test
    public void EqualCardIsEqual() {
	assertTrue(card.equals(new Card(FrenchSuit.CLUB, FrenchType.ACE)));
    }

    @Test
    public void SameCardIsEqual() {
	assertTrue(card.equals(card));
    }

    @Test
    public void testHashCode() {
	assertEquals(12123, new Card(FrenchSuit.HEART, FrenchType.ACE).hashCode());
	assertEquals(12121, new Card(FrenchSuit.CLUB, FrenchType.ACE).hashCode());
    }

    @Test
    public void checkGetNameFormat()
    {
	assertEquals("clubace", card.getName());
    }
    
    @Test
    public void checkToStringFormat()
    {
	assertEquals("0:0: clubace", card.toString());
    }

}
