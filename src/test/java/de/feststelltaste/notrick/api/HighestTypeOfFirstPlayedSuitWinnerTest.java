package de.feststelltaste.notrick.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.player.Player;

public class HighestTypeOfFirstPlayedSuitWinnerTest {

    @Test
    public void secondPlayerWithHighestCardWins() {
	HighestTypeOfFirstPlayedSuitWinner w = new HighestTypeOfFirstPlayedSuitWinner();
	CardSet cardsOfDeal = new CardSet();
	cardsOfDeal.add(TestCard.A2);
	cardsOfDeal.add(TestCard.A1);
	cardsOfDeal.add(TestCard.B2);
	OrderedPlayers players = createThreePlayers();
	Player winner = w.determineWinner(cardsOfDeal, players);
	assertEquals(players.get(1), winner);

    }

    private OrderedPlayers createThreePlayers() {
	OrderedPlayers players = new OrderedPlayers();
	Player p1 = new Player();
	Player p2 = new Player();
	Player p3 = new Player();
	players.add(p1);
	players.add(p2);
	players.add(p3);
	return players;
    }

}
