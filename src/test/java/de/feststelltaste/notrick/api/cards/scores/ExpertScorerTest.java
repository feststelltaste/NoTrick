package de.feststelltaste.notrick.api.cards.scores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.CardSetDataProvider;
import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public class ExpertScorerTest {

    private ExpertScorer expertScorer;
    private CardSet cardSet;

    @Before
    public void setUp() throws Exception {
        expertScorer = new ExpertScorer();
        cardSet = CardSetDataProvider.createFullyFilledCardSet();
    }

    @Test
    public void noCardMeansZero() {
        assertEquals(0, expertScorer.determine(new CardSet()));
    }

    @Test
    public void determineScoreWithNotScoringCard() {
        assertEquals(0, expertScorer.determine(new CardSet()));
    }

    @Test
    public void determineScoreOfOneScoringCard() {
        expertScorer.add(TestCard.A1, 1);
        assertEquals(1, expertScorer.determine(cardSet));
    }

    @Test
    public void determineScoreOfTwoScoringCards() {
        expertScorer.add(TestCard.A1, 1);
        expertScorer.add(TestCard.A2, 2);
        assertEquals(3, expertScorer.determine(cardSet));
    }

    @Test
    public void determineScoreOfType1() {
        expertScorer.add(TestCard.A1.getType(), 1);
        assertEquals(2, expertScorer.determine(cardSet));
    }

    @Test
    public void determineScoreOfSuitA() {
        expertScorer.add(TestCard.A1.getSuit(), 1);
        assertEquals(3, expertScorer.determine(cardSet));
    }

}
