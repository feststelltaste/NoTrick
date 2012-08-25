package de.feststelltaste.notrick.api.cards.dealer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.type.FrenchType;
import de.feststelltaste.notrick.api.cards.dealer.FourCardsAtOnceAfterAnotherDealer;
import de.feststelltaste.notrick.api.cards.deck.CardDeck;
import de.feststelltaste.notrick.api.cards.deck.FrenchShortCardDeck;
import de.feststelltaste.notrick.api.player.Player;

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
	assertEquals(FrenchType.ACE, p1.showCards().asList().get(0).getType());
	assertEquals(FrenchType.TEN, p2.showCards().asList().get(0).getType());
    }

}
