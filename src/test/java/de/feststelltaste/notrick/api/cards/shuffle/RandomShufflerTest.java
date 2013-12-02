package de.feststelltaste.notrick.api.cards.shuffle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;
import de.feststelltaste.notrick.api.cards.deck.CardDeck;
import de.feststelltaste.notrick.api.cards.deck.FrenchShortCardDeck;
import de.feststelltaste.notrick.api.cards.deck.TestCardDeck;

public class RandomShufflerTest {

    RandomShuffler r;

    @Before
    public void setUp() throws Exception {
        r = new RandomShuffler(new FrenchShortCardDeck(), new Random(1l));
    }

    @Test
    public void createRandomShuffler() {
        assertNotNull(new RandomShuffler(new TestCardDeck()));
    }

    @Test
    public void testShuffleCards() {
        CardDeck c = r.shuffleCards();
        List<Card> cards = c.asList();
        Card firstTestCard = new Card(FrenchSuit.HEART, FrenchType.ACE);
        Card middleTestCard = new Card(FrenchSuit.HEART, FrenchType.QUEEN);
        Card lastTestCard = new Card(FrenchSuit.HEART, FrenchType.SEVEN);
        assertEquals(firstTestCard, cards.get(0));
        assertEquals(middleTestCard, cards.get(cards.size() / 2));
        assertEquals(lastTestCard, cards.get(cards.size() - 1));

    }

}
