package de.unitude.notrick.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.type.FrenchType;
import de.unitude.notrick.cards.deck.FrenchSuit;
import de.unitude.notrick.cards.deck.FrenchShortCardDeck;
import de.unitude.notrick.table.CardTable;

public class MustBeCardTypeNeighbourTest {

    MustBeCardTypeNeighbour m;
    private CardTable c;

    @Before
    public void setUp() throws Exception {
	List<Card> cardsOnHand = new ArrayList<Card>();
	FrenchShortCardDeck f = new FrenchShortCardDeck();
	cardsOnHand.add(f.nextCard()); // ACE
	cardsOnHand.add(f.nextCard()); // KING
	c = new CardTable();
	c.add(f.nextCard()); // QUEEN
	m = new MustBeCardTypeNeighbour(cardsOnHand);
    }

    @Test
    public void testGetPlayableCardsCardTable() {
	List<Card> result = m.getPlayableCards(c);
	assertEquals(FrenchType.KING, result.get(0).getType());
    }

    @Test
    public void testGetPlayableCardsCardTableWithGapBetweenCards() {
	Card ace = new Card(FrenchSuit.CLUB, FrenchType.ACE);
	c = new CardTable();
	c.add(ace);
	List<Card> cardsOnHand = new ArrayList<Card>();
	Card queen = new Card(FrenchSuit.CLUB, FrenchType.QUEEN);
	cardsOnHand.add(queen);
	m = new MustBeCardTypeNeighbour(cardsOnHand);
	List<Card> result = m.getPlayableCards(c);
	assertTrue(result.isEmpty());
    }

}
