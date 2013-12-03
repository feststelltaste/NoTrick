package de.feststelltaste.notrick.api.player.ai;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.GermanCardFactory;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.player.ai.SimpleMindedBrain;
import de.feststelltaste.notrick.api.rules.TrickTakingRules;
import de.feststelltaste.notrick.api.table.CardTable;

public class SimpleMindedBrainTest {

    SimpleMindedBrain b;
    private Hand hand;

    @Before
    public void setUp() throws Exception {
        hand = createHand();
        b = new SimpleMindedBrain(new TrickTakingRules());
    }

    private Hand createHand() {
        Hand hand = new Hand(4);
        hand.add(GermanCardFactory.create("E", "10"));
        hand.add(GermanCardFactory.create("E", "9"));
        hand.add(GermanCardFactory.create("S", "7"));
        hand.add(GermanCardFactory.create("H", "K"));
        return hand;
    }

    @Test
    public void testDecideFollowSuit() {
        CardTable table = new CardTable();
        table.add(GermanCardFactory.create("S", "O"));
        Card card = b.decide(table, hand);
        assertEquals(GermanCardFactory.create("S", "7"), card);
    }

    @Test
    public void testDecideDontHaveToFollowSuit() {
        CardTable table = new CardTable();
        table.add(GermanCardFactory.create("G", "A"));
        Card c = b.decide(table, hand);
        assertEquals(GermanCardFactory.create("E", "10"), c);
    }

}
