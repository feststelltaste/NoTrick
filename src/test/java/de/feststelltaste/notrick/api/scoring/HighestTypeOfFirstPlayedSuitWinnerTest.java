package de.feststelltaste.notrick.api.scoring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.Players;
import de.feststelltaste.notrick.api.player.ai.AiPlayer;
import de.feststelltaste.notrick.api.scoring.HighestTypeOfFirstPlayedSuitWinner;

public class HighestTypeOfFirstPlayedSuitWinnerTest {

    @Test
    public void secondPlayerWithHighestCardWins() {
        HighestTypeOfFirstPlayedSuitWinner w = new HighestTypeOfFirstPlayedSuitWinner();
        CardSet cardsOfDeal = new CardSet();
        cardsOfDeal.add(TestCard.A2);
        cardsOfDeal.add(TestCard.A1);
        cardsOfDeal.add(TestCard.B2);
        Players players = createThreePlayers();
        Player winner = w.determineWinner(cardsOfDeal, players);
        assertEquals(players.get(1), winner);

    }

    private Players createThreePlayers() {
        Players players = new Players();
        Player p1 = new AiPlayer("p1", new Hand(8));
        Player p2 = new AiPlayer("p2", new Hand(8));
        Player p3 = new AiPlayer("p3", new Hand(8));
        players.add(p1);
        players.add(p2);
        players.add(p3);
        return players;
    }

}
