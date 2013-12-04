package de.feststelltaste.notrick.api.player.ai;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.GermanCardFactory;

public class CanReturnFirstSuitableCardAiTest {

    private CanReturnFirstSuitableCardAi b;
    private CardSet testCardSet;

    @Before
    public void setUp() throws Exception {
        testCardSet = createCardSet();
        b = new CanReturnFirstSuitableCardAi();
    }

    private CardSet createCardSet() {
        CardSet cardSet = new CardSet();
        cardSet.add(GermanCardFactory.create("S", "7"));
        cardSet.add(GermanCardFactory.create("H", "K"));
        return cardSet;
    }

    @Test
    public void playsFirstCardOnHand() {
        CardSet cardsOnTable = new CardSet();
        cardsOnTable.add(GermanCardFactory.create("S", "O"));
        
        Card cardToBePlayed = b.decide(cardsOnTable, testCardSet);
        
        assertEquals(GermanCardFactory.create("S", "7"), cardToBePlayed);
    }

}
