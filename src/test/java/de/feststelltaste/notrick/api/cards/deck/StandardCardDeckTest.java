package de.feststelltaste.notrick.api.cards.deck;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.sorting.PriorityCardComparator;

public abstract class StandardCardDeckTest {

    protected CardDeck cardDeck;

    @Test
    public void checkConsitentCardDeckOrder() {

        int i = 0;
        int suit = 0;
        int type = 0;

        while (cardDeck.hasCards()) {
            Card c = cardDeck.nextCard();
            suit = i / cardDeck.numberOfTypes();
            type = i % cardDeck.numberOfTypes();
            // for debugging purposes
            // System.out.println(suit + ":" + c.getSuit().getPriority() + "|" +
            // type + ":" + c.getType().getPriority());
            assertEquals(suit, c.getSuit().getPriority());
            assertEquals(type, c.getType().getPriority());
            i++;
        }
    }

    @Test
    public void checkCardHashCodes() {
        Set<Card> cards = new HashSet<Card>(cardDeck.asList());
        assertEquals(cardDeck.getDeckSize(), cards.size());
    }

    @Test
    public void testInitCardDeckOrderingWithComparator() {
        PriorityCardComparator comparator = new PriorityCardComparator();
        Card formerCard = cardDeck.nextCard();
        while (cardDeck.hasCards()) {
            Card currentCard = cardDeck.nextCard();
            assertEquals(1, comparator.compare(formerCard, currentCard));
            formerCard = currentCard;
        }
    }

}
