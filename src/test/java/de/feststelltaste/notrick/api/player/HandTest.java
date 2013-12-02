package de.feststelltaste.notrick.api.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
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
    public void addCards() {
        hand.add(new Card(GermanSuit.EICHEL, GermanType.ASS));
        hand.add(new Card(GermanSuit.GRUEN, GermanType.ASS));
        hand.add(new Card(GermanSuit.HERZ, GermanType.ASS));
        hand.add(new Card(GermanSuit.SCHELLEN, GermanType.ASS));
        Card lastCardOfFirstSuit = hand.getAllCards().asList().get(HAND_SIZE - 1);
        assertEquals(GermanSuit.SCHELLEN, lastCardOfFirstSuit.getSuit());
    }

    @Test
    public void sizeCheck() {
        assertEquals(0, hand.size());
        hand.add(TestCard.A1);
        assertEquals(1, hand.size());
    }

    @Test
    public void testSet() {
        CardSet c = new CardSet();
        c.add(TestCard.A1);
        c.add(TestCard.A2);
        hand.set(c);
        assertTrue(hand.getAllCards().has(TestCard.A1));
        assertTrue(hand.getAllCards().has(TestCard.A2));
        assertFalse(hand.getAllCards().has(TestCard.A3));
    }

    @Test
    public void addEmptyCardSet() {
        CardSet additionalCardSet = new CardSet();
        hand.add(additionalCardSet);
        assertEquals(0, hand.size());
    }

    @Test
    public void addCardSet() {
        CardSet additionalCardSet = new CardSet();
        additionalCardSet.add(TestCard.A2);
        additionalCardSet.add(TestCard.A1);
        hand.add(additionalCardSet);
        assertEquals(2, hand.size());
        assertEquals(TestCard.A1, hand.getAllCards().asList().get(0));
        assertEquals(TestCard.A2, hand.getAllCards().asList().get(1));
    }

    @Test
    public void testTooManyCardsOnHand() {
        hand = new Hand(1);
        hand.add(TestCard.A1);
        try {
            hand.add(TestCard.A2);
        } catch (TooManyCardsForHandException expected) {
            // expected
        }
    }

}
