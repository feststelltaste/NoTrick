package de.unitude.notrick.player;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.GermanColor;
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
	hand.add(new Card(GermanColor.HERZ, GermanType.ASS));
	hand.add(new Card(GermanColor.GRUEN, GermanType.ASS));
	hand.add(new Card(GermanColor.SCHELLEN, GermanType.ASS));
	hand.add(new Card(GermanColor.EICHEL, GermanType.ASS));
	Card lastCardOfFirstColor = hand.getAllCards().get(handSize - 1);
	assertEquals(GermanColor.SCHELLEN, lastCardOfFirstColor.getColor());
    }

}
