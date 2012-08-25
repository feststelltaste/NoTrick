package de.feststelltaste.notrick.api.rules;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.FrenchCardFactory;
import de.feststelltaste.notrick.api.cards.card.suit.FrenchSuit;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;

public class MustPlaySameSuitIfAvailableRuleTest {

    MustPlaySameSuitIfAvailableRule m;

    @Test
    public void allCardsFitIfCardTableIsEmpty() {
	Card clubAce = new Card(FrenchSuit.CLUB, FrenchType.ACE);
	Card diamondAce = new Card(FrenchSuit.DIAMOND, FrenchType.KING);
	List<Card> cardsToFilter = new ArrayList<Card>();
	cardsToFilter.add(clubAce);
	cardsToFilter.add(diamondAce);

	m = new MustPlaySameSuitIfAvailableRule();
	List<Card> result = m.getPlayableCards(new ArrayList<Card>(), cardsToFilter);
	assertEquals(clubAce, result.get(0));
	assertEquals(diamondAce, result.get(1));

    }

    @Test
    public void playsCardOfSameSuit() {
	List<Card> cardsToFilter = new ArrayList<Card>();
	Card clubAce = FrenchCardFactory.create("C", "A");
	cardsToFilter.add(clubAce);
	m = new MustPlaySameSuitIfAvailableRule();

	List<Card> cardsOnTable = new ArrayList<Card>();
	cardsOnTable.add(FrenchCardFactory.create("C", "K"));

	List<Card> result = m.getPlayableCards(cardsOnTable, cardsToFilter);
	assertEquals(clubAce, result.get(0));
    }

    @Test
    public void playsDifferentSuitIfSuitNotAvailable() {
	List<Card> cardsToFilter = new ArrayList<Card>();
	Card diamondAce = FrenchCardFactory.create("D", "A");
	cardsToFilter.add(diamondAce);
	m = new MustPlaySameSuitIfAvailableRule();

	List<Card> cardsOnTable = new ArrayList<Card>();
	cardsOnTable.add(FrenchCardFactory.create("C", "A"));

	List<Card> result = m.getPlayableCards(cardsOnTable, cardsToFilter);
	assertEquals(diamondAce, result.get(0));
    }

}
