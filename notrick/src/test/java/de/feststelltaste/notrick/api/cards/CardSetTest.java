package de.feststelltaste.notrick.api.cards;

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

public class CardSetTest {

    private CardSet cards;
    private Card queenOfHearts = FrenchCardFactory.create("H", "Q");
    private Card jackOfSpades = FrenchCardFactory.create("S", "J");

    @Before
    public void setUp() throws Exception {
	this.cards = new CardSet();
	cards.add(queenOfHearts);
	cards.add(jackOfSpades);
    }

    @Test
    public void addingAndHavingCards() {
	assertTrue(cards.has(queenOfHearts));
	assertTrue(cards.has(jackOfSpades));
	
	cards.add(jackOfSpades);
    }
    
    @Test
    public void checkIterator(){
	Iterator<Card> iterator = cards.iterator();
	assertTrue(iterator.hasNext());
	assertTrue(iterator.next() instanceof Card);
	assertTrue(iterator.next() instanceof Card);
	assertFalse(iterator.hasNext());
	
	try{
	    iterator.next();
	    fail();
	}
	catch (NoSuchElementException expected) {
	    //expected
	}
	
    }


}
