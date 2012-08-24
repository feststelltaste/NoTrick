package de.unitude.notrick.rules;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.suit.FrenchSuit;
import de.unitude.notrick.cards.card.type.FrenchType;
import de.unitude.notrick.table.CardTable;

public class MustPlaySameSuitIfAvailableRuleTest {

    MustPlaySameSuitIfAvailableRule m;

    @Test
    public void testGetPlayableCardsWithNoCardOnCardTable() {
	List<Card> cardsOnHand = new ArrayList<Card>();
	Card clubAce = new Card(FrenchSuit.CLUB, FrenchType.ACE);
	Card diamondAce = new Card(FrenchSuit.DIAMOND, FrenchType.KING);

	cardsOnHand.add(clubAce);
	cardsOnHand.add(diamondAce);

	m = new MustPlaySameSuitIfAvailableRule(cardsOnHand);
	List<Card> result = m.getPlayableCards(new CardTable());
	assertEquals(clubAce, result.get(0));
	assertEquals(diamondAce, result.get(1));

    }

    @Test
    public void testGetPlayableCardsWithNoPlayableCardOnHand() {
	List<Card> cardsOnHand = new ArrayList<Card>();
	Card diamondAce = new Card(FrenchSuit.DIAMOND, FrenchType.KING);
	cardsOnHand.add(diamondAce);
	m = new MustPlaySameSuitIfAvailableRule(cardsOnHand);

	CardTable c = new CardTable();
	c.add(new Card(FrenchSuit.CLUB, FrenchType.ACE));

	List<Card> result = m.getPlayableCards(c);
	assertEquals(diamondAce, result.get(0));
    }

}