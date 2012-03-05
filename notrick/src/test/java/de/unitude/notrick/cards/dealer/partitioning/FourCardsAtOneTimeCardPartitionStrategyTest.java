package de.unitude.notrick.cards.dealer.partitioning;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.GermanColor;
import de.unitude.notrick.cards.card.type.GermanType;
import de.unitude.notrick.cards.deck.CardDeck;
import de.unitude.notrick.cards.deck.GermanCardDeck;
import de.unitude.notrick.player.Hand;

public class FourCardsAtOneTimeCardPartitionStrategyTest {

    FourCardsAtOneTimeCardPartitionStrategy sut;
    CardDeck cardDeck = new GermanCardDeck();
    List<Hand> hands;
    int cardsPerPlayer = cardDeck.getDeckSize() / 4;

    @Before
    public void setUp() throws Exception {
	hands = new ArrayList<Hand>(4);
	hands.add(new Hand(cardsPerPlayer));
	hands.add(new Hand(cardsPerPlayer));
	hands.add(new Hand(cardsPerPlayer));
	hands.add(new Hand(cardsPerPlayer));

	sut = new FourCardsAtOneTimeCardPartitionStrategy(new GermanCardDeck(),
		hands);
    }

    @Test
    public void testComputeNext() {
	assertEquals(0, sut.computeNext(0));
	assertEquals(0, sut.computeNext(1));
	assertEquals(0, sut.computeNext(2));
	assertEquals(0, sut.computeNext(3));
	assertEquals(1, sut.computeNext(4));
	assertEquals(2, sut.computeNext(4 * 2));
	assertEquals(3, sut.computeNext(4 * 3));
	assertEquals(0, sut.computeNext(4 * 4));
	assertEquals(3, sut.computeNext(cardDeck.getDeckSize() - 1));

    }

    @Test
    public void testPart() {
	sut.part();

	assertEquals(cardsPerPlayer, hands.get(0).size());

	Card firstCardOfLastPlayer = hands.get(hands.size() - 1).getAllCards()
		.get(0);
	assertEquals(GermanColor.GRUEN, firstCardOfLastPlayer.getColor());
	assertEquals(GermanType.UNTER, firstCardOfLastPlayer.getType());

	Card lastCardOfLastPlayer = hands.get(hands.size() - 1).getAllCards()
		.get(cardsPerPlayer - 1);
	assertEquals(GermanColor.SCHELLEN, lastCardOfLastPlayer.getColor());
	assertEquals(GermanType.SIEBNER, lastCardOfLastPlayer.getType());
    }

}
