package de.feststelltaste.notrick.api.player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.game.Play;

public class PlayerScoreTest {

    @Test
    public void testScoreKeeping() {
        PlayerScore playerScore = new PlayerScore();
        Play play1 = new Play("play1") {

            @Override
            public void start() {
                
            }
        };
        Play play2 = new Play("play2") {

            @Override
            public void start() {
                
            }
        };

        playerScore.addScore(play1, 1);
        playerScore.addScore(play2, 1);
        playerScore.addScore(play1, 1);

        assertEquals(2, playerScore.getScore(play1));
        assertEquals(1, playerScore.getScore(play2));
    }

}
