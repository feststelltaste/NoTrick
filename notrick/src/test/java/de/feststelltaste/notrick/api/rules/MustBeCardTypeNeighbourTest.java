package de.feststelltaste.notrick.api.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.FrenchCardFactory;
import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

public class MustBeCardTypeNeighbourTest {

    private MustBeCardTypeNeighbour m;
    private List<Card> alreadyPlayedCards;
    private List<Card> cardsOnHand;

    @Before
    public void setUp() throws Exception {
	cardsOnHand = createClubsCardsOnly();
	alreadyPlayedCards = new ArrayList<Card>();
	alreadyPlayedCards.add(FrenchCardFactory.create("C", "Q"));
	m = new MustBeCardTypeNeighbour();
    }

    private List<Card> createClubsCardsOnly() {
	List<Card> cards = new ArrayList<Card>();
	cards.add(FrenchCardFactory.create("C", "A"));
	cards.add(FrenchCardFactory.create("C", "K"));
	return cards;
    }

    @Test
    public void testGetPlayableCardsCardTable() {
	List<Card> result = m.getPlayableCards(alreadyPlayedCards, cardsOnHand);
	assertEquals(FrenchType.KING, result.get(0).getType());
    }

    @Test
    public void testGetPlayableCardsCardTableWithGapBetweenCards() {
	alreadyPlayedCards.add(FrenchCardFactory.create("C", "A"));
	List<Card> cardsOnHand = new ArrayList<Card>();
	Card queen = new Card(FrenchSuit.CLUB, FrenchType.QUEEN);
	cardsOnHand.add(queen);
	m = new MustBeCardTypeNeighbour();
	List<Card> result = m.getPlayableCards(alreadyPlayedCards, cardsOnHand);
	assertTrue(result.isEmpty());
    }

}
