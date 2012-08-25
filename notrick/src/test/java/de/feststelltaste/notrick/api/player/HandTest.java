package de.feststelltaste.notrick.api.player;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

public class HandTest {

    private Hand hand;
    private final int HAND_SIZE = 4;

    @Before
    public void setUp() {
	hand = new Hand(HAND_SIZE);
    }

    @Test
    public void testAdd() {
	hand.add(new Card(GermanSuit.HERZ, GermanType.ASS));
	hand.add(new Card(GermanSuit.GRUEN, GermanType.ASS));
	hand.add(new Card(GermanSuit.SCHELLEN, GermanType.ASS));
	hand.add(new Card(GermanSuit.EICHEL, GermanType.ASS));
	Card lastCardOfFirstSuit = hand.getAllCards().asList().get(HAND_SIZE - 1);
	assertEquals(GermanSuit.SCHELLEN, lastCardOfFirstSuit.getSuit());
    }

}
