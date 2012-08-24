package de.unitude.notrick.player;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.suit.GermanSuit;
import de.unitude.notrick.cards.card.type.GermanType;
import de.unitude.notrick.cards.deck.CardDeck;
import de.unitude.notrick.cards.deck.GermanCardDeck;
import de.unitude.notrick.player.Hand;

public class HandTest {

    Hand hand;
    int handSize = 4;
    CardDeck cardDeck;

    @Before
    public void setUp() {
	cardDeck = new GermanCardDeck();
	hand = new Hand(handSize);
    }

    @Test
    public void testAdd() {
	hand.add(new Card(GermanSuit.HERZ, GermanType.ASS));
	hand.add(new Card(GermanSuit.GRUEN, GermanType.ASS));
	hand.add(new Card(GermanSuit.SCHELLEN, GermanType.ASS));
	hand.add(new Card(GermanSuit.EICHEL, GermanType.ASS));
	Card lastCardOfFirstSuit = hand.getAllCards().get(handSize - 1);
	assertEquals(GermanSuit.SCHELLEN, lastCardOfFirstSuit.getSuit());
    }

}
