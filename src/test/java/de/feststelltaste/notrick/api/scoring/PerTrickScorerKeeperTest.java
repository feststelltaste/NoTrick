package de.feststelltaste.notrick.api.scoring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.scoring.PerTrickScorerKeeper;

public class PerTrickScorerKeeperTest {

    private PerTrickScorerKeeper perTrickScorerKeeper;

    @Before
    public void setUp() throws Exception {
        perTrickScorerKeeper = new PerTrickScorerKeeper();
    }

    @Test
    public void noCardsScoresZero() {
        assertEquals(0, perTrickScorerKeeper.determine(new CardSet()));
    }

    @Test
    public void oneCardScoresOne() {
        CardSet c = new CardSet();
        c.add(TestCard.A1);
        assertEquals(1, perTrickScorerKeeper.determine(c));
    }

}
