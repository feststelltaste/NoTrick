package de.unitude.notrick.cards.dealer.dealing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.unitude.notrick.cards.card.type.FrenchType;
import de.unitude.notrick.cards.deck.CardDeck;
import de.unitude.notrick.cards.deck.FrenchShortCardDeck;
import de.unitude.notrick.player.Player;

public class FourCardsAtOnceAfterAnotherDealerTest {

    Player p1;
    Player p2;
    CardDeck c;

    FourCardsAtOnceAfterAnotherDealer d;

    @Before
    public void setUp() throws Exception {
	p1 = new Player();
	p2 = new Player();
	List<Player> p = new ArrayList<Player>();
	p.add(p1);
	p.add(p2);
	c = new FrenchShortCardDeck();
	d = new FourCardsAtOnceAfterAnotherDealer(c, p);
    }

    @Test
    public void testDeal() {
	d.deal();
	assertEquals(FrenchType.ACE, p1.showCards().get(0).getType());
	assertEquals(FrenchType.TEN, p2.showCards().get(0).getType());
    }

}
