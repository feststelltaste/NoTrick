package de.unitude.notrick.cards.deck;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.sorting.PriorityCardComparator;

public abstract class StandardCardDeckTest {

    protected CardDeck cardDeck;
        
    @Test
    public void checkCardDeckConsistency() {

	int i = 0;
	int suit = 0;
	int type = 0;

	while (cardDeck.hasCards()) {
	    Card c = cardDeck.nextCard();
	    suit = i / cardDeck.numberOfTypes();
	    type = i % cardDeck.numberOfTypes();
	    // for debugging
	    // System.out.println(suit + ":" + c.getSuit().getPriority() + "|" + type + ":" + c.getType().getPriority() + "- " + cardDeck.numberOfTypes());
	    assertEquals(suit, c.getSuit().getPriority());
	    assertEquals(type, c.getType().getPriority());
	    i++;
	}
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
