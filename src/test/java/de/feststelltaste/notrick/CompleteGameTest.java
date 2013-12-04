package de.feststelltaste.notrick;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.feststelltaste.notrick.api.game.NoTrickGame;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.Players;
import de.feststelltaste.notrick.api.player.ai.AiPlayer;

public class CompleteGameTest {
    
    private  NoTrickGame noTrickGame;
    private Players players;

    @Before
    public void setUp(){
        Player computerPlayer1 = new AiPlayer("Player1", new Hand(8));
        Player computerPlayer2 = new AiPlayer("Player2", new Hand(8));
        Player computerPlayer3 = new AiPlayer("Player3", new Hand(8));
        Player computerPlayer4 = new AiPlayer("Player4", new Hand(8));

        players = new Players();
        players.add(computerPlayer1);
        players.add(computerPlayer2);
        players.add(computerPlayer3);
        players.add(computerPlayer4);
        
        noTrickGame = new NoTrickGame(players);
    }
    @Test
    public void testCompleteGame() {
        while (!noTrickGame.hasFinished()) {
            noTrickGame.nextRound();

        }

        assertEquals(0, players.get(0).getOverallScore());
        assertEquals(0, players.get(0).getCurrentScore());
        assertEquals(12, players.get(1).getOverallScore());
        assertEquals(12, players.get(2).getOverallScore());
        assertEquals(8, players.get(3).getOverallScore());
    }

}
