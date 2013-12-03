package de.feststelltaste.notrick;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.game.NoTrickGame;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.Players;
import de.feststelltaste.notrick.api.player.ai.ComputerPlayer;

public class CompleteGameTest {

    @Test
    public void testCompleteGame() {
        Player computerPlayer1 = new ComputerPlayer("Player1", new Hand(8));
        Player computerPlayer2 = new ComputerPlayer("Player2", new Hand(8));
        Player computerPlayer3 = new ComputerPlayer("Player3", new Hand(8));
        Player computerPlayer4 = new ComputerPlayer("Player4", new Hand(8));

        Players players = new Players();
        players.add(computerPlayer1);
        players.add(computerPlayer2);
        players.add(computerPlayer3);
        players.add(computerPlayer4);

        NoTrickGame noTrickGame = new NoTrickGame(players);

        while (!noTrickGame.hasFinished()) {
            noTrickGame.nextRound();
            
        }
        
        assertEquals(16, computerPlayer1.getOverallScore());
        assertEquals(16, computerPlayer1.getCurrentScore());
        assertEquals(8, computerPlayer2.getOverallScore());
        assertEquals(4, computerPlayer3.getOverallScore());
        assertEquals(4, computerPlayer4.getOverallScore());
    }

}
