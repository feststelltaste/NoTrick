package de.feststelltaste.notrick.api.rules;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.FrenchCardFactory;
import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;
import de.feststelltaste.notrick.api.rules.MustPlaySameSuitIfAvailableRule;

public class MustPlaySameSuitIfAvailableRuleTest {

    MustPlaySameSuitIfAvailableRule m;

    @Test
    public void allCardsFitIfCardTableIsEmpty() {
        Card clubAce = new Card(FrenchSuit.CLUB, FrenchType.ACE);
        Card diamondAce = new Card(FrenchSuit.DIAMOND, FrenchType.KING);
        CardSet cardsToFilter = new CardSet();
        cardsToFilter.add(clubAce);
        cardsToFilter.add(diamondAce);

        m = new MustPlaySameSuitIfAvailableRule();
        CardSet result = m.getPlayableCards(new CardSet(), cardsToFilter);
        assertEquals(clubAce, result.asList().get(0));
        assertEquals(diamondAce, result.asList().get(1));

    }

    @Test
    public void playsCardOfSameSuit() {
        CardSet cardsToFilter = new CardSet();
        Card clubAce = FrenchCardFactory.create("C", "A");
        cardsToFilter.add(clubAce);
        m = new MustPlaySameSuitIfAvailableRule();

        CardSet cardsOnTable = new CardSet();
        cardsOnTable.add(FrenchCardFactory.create("C", "K"));

        CardSet result = m.getPlayableCards(cardsOnTable, cardsToFilter);
        assertEquals(clubAce, result.asList().get(0));
    }

    @Test
    public void playsDifferentSuitIfSuitNotAvailable() {
        CardSet cardsToFilter = new CardSet();
        Card diamondAce = FrenchCardFactory.create("D", "A");
        cardsToFilter.add(diamondAce);
        m = new MustPlaySameSuitIfAvailableRule();

        CardSet cardsOnTable = new CardSet();
        cardsOnTable.add(FrenchCardFactory.create("C", "A"));

        CardSet result = m.getPlayableCards(cardsOnTable, cardsToFilter);
        assertEquals(diamondAce, result.asList().get(0));
    }

}
