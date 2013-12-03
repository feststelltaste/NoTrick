package de.feststelltaste.notrick.api.scoring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.CardSetDataProvider;
import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.suit.TestSuit;
import de.feststelltaste.notrick.api.cards.card.suit.TestType;
import de.feststelltaste.notrick.api.scoring.ConfigurableScorerKeeper;
import de.feststelltaste.notrick.api.scoring.ConfigurableScorerKeeper.ConfigurableScorerKeeperBuilder;

public class ConfigurableScorerKeeperTest {

    private ConfigurableScorerKeeperBuilder builder;

    @Before
    public void setUpBuilder() {
        builder = new ConfigurableScorerKeeperBuilder();
    }

    @Test
    public void noCardMeansZero() {
        assertEquals(0, builder.build().determine(createFullCardSet()));
    }

    @Test
    public void determineScoreWithNoScoringCard() {
        assertEquals(0, builder.build().determine(createFullCardSet()));
    }

    @Test
    public void determineScoreOfOneScoringCard() {
        builder.add(TestCard.A1, 1);
        ConfigurableScorerKeeper configurableScorer = builder.build();
        assertEquals(1, configurableScorer.determine(createFullCardSet()));
    }

    @Test
    public void determineScoreOfTwoScoringCards() {
        builder.add(TestCard.A1, 1);
        builder.add(TestCard.A2, 2);
        ConfigurableScorerKeeper configurableScorer = builder.build();
        assertEquals(3, configurableScorer.determine(createFullCardSet()));
    }

    @Test
    public void determineScoreOfType1() {
        builder.add(TestCard.A1.getType(), 1);
        ConfigurableScorerKeeper configurableScorer = builder.build();
        assertEquals(2, configurableScorer.determine(createFullCardSet()));
    }

    @Test
    public void determineScoreOfSuitA() {
        builder.add(TestCard.A1.getSuit(), 1);
        ConfigurableScorerKeeper configurableScorer = builder.build();
        assertEquals(3, configurableScorer.determine(createFullCardSet()));
    }

    @Test
    public void determinesScoreOfSuitAndTypes() {
        builder.add(TestSuit.A, 5);
        builder.add(TestType.ONE, 100);
        ConfigurableScorerKeeper configurableScorer = builder.build();
        assertEquals(215, configurableScorer.determine(createFullCardSet()));
    }

    private CardSet createFullCardSet() {
        return CardSetDataProvider.createFullyFilledCardSet();
    }

}
