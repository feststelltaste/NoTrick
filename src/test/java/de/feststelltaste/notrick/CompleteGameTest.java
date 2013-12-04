package de.feststelltaste.notrick;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.game.NoTrickGame;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.Players;
import de.feststelltaste.notrick.api.player.ai.AiPlayer;

public class CompleteGameTest {

    @Test
    public void testCompleteGame() {
        Player computerPlayer1 = new AiPlayer("Player1", new Hand(8));
        Player computerPlayer2 = new AiPlayer("Player2", new Hand(8));
        Player computerPlayer3 = new AiPlayer("Player3", new Hand(8));
        Player computerPlayer4 = new AiPlayer("Player4", new Hand(8));

        Players players = new Players();
        players.add(computerPlayer1);
        players.add(computerPlayer2);
        players.add(computerPlayer3);
        players.add(computerPlayer4);

        NoTrickGame noTrickGame = new NoTrickGame(players);

        while (!noTrickGame.hasFinished()) {
            noTrickGame.nextRound();
            
        }
        
        assertEquals(0, computerPlayer1.getOverallScore());
        assertEquals(0, computerPlayer1.getCurrentScore());
        assertEquals(0, computerPlayer2.getOverallScore());
        assertEquals(4, computerPlayer3.getOverallScore());
        assertEquals(28, computerPlayer4.getOverallScore());
    }

}
