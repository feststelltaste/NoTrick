package de.feststelltaste.notrick.api.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.FrenchCardFactory;
import de.feststelltaste.notrick.api.cards.card.suit.TestSuit;

public class CardSetTest {

    private CardSet cardSet;
    private Card queenOfHearts = FrenchCardFactory.create("H", "Q");
    private Card jackOfSpades = FrenchCardFactory.create("S", "J");

    @Before
    public void setUp() throws Exception {
        this.cardSet = new CardSet();
        this.cardSet.add(queenOfHearts);
        this.cardSet.add(jackOfSpades);
    }

    @Test
    public void addingAndHavingCards() {
        assertFalse("Should not have card", this.cardSet.has(FrenchCardFactory.create("C", "9")));
        assertTrue("Should have card " + queenOfHearts.getName(), this.cardSet.has(queenOfHearts));
        assertTrue("Should have card " + jackOfSpades.getName(), this.cardSet.has(jackOfSpades));
    }

    @Test
    public void checkIterator() {
        Iterator<Card> iterator = cardSet.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() instanceof Card);
        assertTrue(iterator.next() instanceof Card);
        assertFalse(iterator.hasNext());

        try {
            iterator.next();
            fail();
        } catch (NoSuchElementException expected) {
            // expected
        }

    }

    @Test
    public void hasSuitA() {
        CardSet cardSet = new CardSet();
        cardSet.add(TestCard.A1);
        assertTrue(cardSet.has(TestSuit.A));
        assertFalse(cardSet.has(TestSuit.B));
    }

    @Test
    public void filterSuitA() {
        CardSet cardSet = CardSetDataProvider.createFullyFilledCardSet();
        assertEquals(3, cardSet.filter(TestSuit.A).size());
    }

}
