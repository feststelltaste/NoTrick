package de.feststelltaste.notrick.api.player;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.GermanCardFactory;
import de.feststelltaste.notrick.api.table.CardTable;

public class SimpleMindedBrainTest {

    SimpleMindedBrain b;
    @Before
    public void setUp() throws Exception {
	Hand hand = new Hand(4);
	hand.add(GermanCardFactory.create("E", "10"));
	hand.add(GermanCardFactory.create("E", "9"));
	hand.add(GermanCardFactory.create("S", "7"));
	hand.add(GermanCardFactory.create("H", "K"));
	b = new SimpleMindedBrain(hand);
    }

    @Test
    public void testDecideFollowSuit()
    {
	CardTable table = new CardTable();
	table.add(GermanCardFactory.create("S", "O"));
	Card card = b.decide(table);
	assertEquals(GermanCardFactory.create("S", "7"), card);
    }
    
    @Test
    public void testDecideDontHaveToFollowSuit()
    {
	CardTable table = new CardTable();
	table.add(GermanCardFactory.create("G", "A"));
	Card card = b.decide(table);
	assertEquals(GermanCardFactory.create("E", "10"), card);
    }

}
