package de.feststelltaste.notrick.api.cards.dealer.partitioning;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.GermanSuit;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;
import de.feststelltaste.notrick.api.cards.dealer.partitioning.SpecificNumberOfCardsAtOneTimePartitionStrategy;
import de.feststelltaste.notrick.api.cards.deck.GermanCardDeck;

public class SpecificNumberOfCardsAtOneTimePartitionStrategyTest {

    private static final int FOUR_CARDS = 4;
    SpecificNumberOfCardsAtOneTimePartitionStrategy sut;

    @Before
    public void setUp() throws Exception {
	sut = new SpecificNumberOfCardsAtOneTimePartitionStrategy(new GermanCardDeck(), FOUR_CARDS);
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
