package de.feststelltaste.notrick.api.cards.dealer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.deck.CardDeck;
import de.feststelltaste.notrick.api.cards.deck.TestCardDeck;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.Players;
import de.feststelltaste.notrick.api.player.ai.AiPlayer;

public class FourCardsAtOnceAfterAnotherDealerTest {

    @Test
    public void testDeal() {
        CardDeck cardDeck = new TestCardDeck();
        Player player1 = new AiPlayer("p1",new Hand(8));
        Player player2 = new AiPlayer("p2",new Hand(8));
        Players players=  new Players();
        players.add(player1);
        players.add(player2);
        Dealer d = new FourCardsAtOnceAfterAnotherDealer(cardDeck, players);
        
        d.deal();
        
        assertEquals(TestCard.A1, player1.showCards().asList().get(0));
        assertEquals(TestCard.B2, player2.showCards().asList().get(0));
    }

}
