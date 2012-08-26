package de.feststelltaste.notrick.api.player;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.TestCard;
import de.feststelltaste.notrick.api.cards.scores.TrickBasedScorer;

public class ScoringPileTest {
    
    private ScoringPile scoringPile;

    @Before
    public void setUp() throws Exception {
	scoringPile = new ScoringPile(new TrickBasedScorer());
    }

    @Test
    public void countScoreWithNoCards()
    {
	assertEquals(0, scoringPile.countScore());
    }
    
    @Test
    public void countScoreWithCards()
    {
	scoringPile.add(TestCard.A1);
	CardSet someCards = new CardSet();
	someCards.add(TestCard.A2);
	someCards.add(TestCard.B1);
	scoringPile.add(someCards);
	assertEquals(3, scoringPile.countScore());
    }

}
