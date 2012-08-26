package de.feststelltaste.notrick.api.cards.scores;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public class TrickBasedScorerTest {

    private TrickBasedScorer s;
    
    @Before
    public void setUp() throws Exception {
	s = new TrickBasedScorer();
    }
    
    @Test
    public void noCardsScoresZero(){
	assertEquals(0, s.determine(new CardSet()));
    }
    
    @Test
    public void oneCardScoresOne(){
	CardSet c = new CardSet();
	c.add(TestCard.A1);
	assertEquals(1, s.determine(c));
    }
    
    

}
