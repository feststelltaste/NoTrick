package de.feststelltaste.notrick.api.cards;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.FrenchCardFactory;
import de.feststelltaste.notrick.api.cards.card.GermanCardFactory;
import de.feststelltaste.notrick.api.cards.card.type.GermanType;

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
	CardSet cardSet = new CardSet();
	cardSet.add(queenOfHearts);
	cardSet.add(jackOfSpades);
	assertFalse("Should not have card", cardSet.has(FrenchCardFactory.create("C", "9")));
	assertTrue("Should have card " + queenOfHearts.getName(), cardSet.has(queenOfHearts));
	assertTrue("Should have card " + jackOfSpades.getName(), cardSet.has(jackOfSpades));
    }
    
    @Test
    public void checkIterator(){
	Iterator<Card> iterator = cardSet.iterator();
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
