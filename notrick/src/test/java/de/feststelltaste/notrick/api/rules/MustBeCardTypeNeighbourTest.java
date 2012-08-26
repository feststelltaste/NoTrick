package de.feststelltaste.notrick.api.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.FrenchCardFactory;
import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

public class MustBeCardTypeNeighbourTest {

    private MustBeCardTypeNeighbour m;
    private CardSet alreadyPlayedCards;
    private CardSet cardsOnHand;

    @Before
    public void setUp() throws Exception {
	cardsOnHand = createClubsCardsOnly();
	alreadyPlayedCards = new CardSet();
	alreadyPlayedCards.add(FrenchCardFactory.create("C", "Q"));
	m = new MustBeCardTypeNeighbour();
    }

    private CardSet createClubsCardsOnly() {
	CardSet cards = new CardSet();
	cards.add(FrenchCardFactory.create("C", "A"));
	cards.add(FrenchCardFactory.create("C", "K"));
	return cards;
    }

    @Test
    public void testGetPlayableCardsCardTable() {
	CardSet result = m.getPlayableCards(alreadyPlayedCards, cardsOnHand);
	assertEquals(FrenchType.KING, result.asList().get(0).getType());
    }

    @Test
    public void testGetPlayableCardsCardTableWithGapBetweenCards() {
	alreadyPlayedCards.add(FrenchCardFactory.create("C", "A"));
	CardSet cardsOnHand = new CardSet();
	Card queen = new Card(FrenchSuit.CLUB, FrenchType.QUEEN);
	cardsOnHand.add(queen);
	m = new MustBeCardTypeNeighbour();
	CardSet result = m.getPlayableCards(alreadyPlayedCards, cardsOnHand);
	assertTrue(result.isEmpty());
    }

}
