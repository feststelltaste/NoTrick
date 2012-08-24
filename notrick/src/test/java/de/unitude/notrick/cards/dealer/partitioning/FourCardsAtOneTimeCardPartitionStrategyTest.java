package de.unitude.notrick.cards.dealer.partitioning;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.suit.GermanSuit;
import de.unitude.notrick.cards.card.type.GermanType;
import de.unitude.notrick.cards.deck.GermanCardDeck;

public class FourCardsAtOneTimeCardPartitionStrategyTest {

    SpecificNumberOfCardsAtOneTimePartitionStrategy sut;

    @Before
    public void setUp() throws Exception {
	sut = new SpecificNumberOfCardsAtOneTimePartitionStrategy(new GermanCardDeck(), 4);
    }

    @Test
    public void testNextPart() {
	List<Card> firstPart = sut.nextPart();
	List<Card> lastPart = null;
	while (sut.hasCards())
	    lastPart = sut.nextPart();

	assertEquals(4, firstPart.size());
	Card lastCardOfLastPlayer = lastPart.get(lastPart.size() - 1);
	assertEquals(GermanSuit.SCHELLEN, lastCardOfLastPlayer.getSuit());
	assertEquals(GermanType.SIEBNER, lastCardOfLastPlayer.getType());
    }

}
