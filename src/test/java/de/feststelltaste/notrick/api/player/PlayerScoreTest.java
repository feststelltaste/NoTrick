package de.feststelltaste.notrick.api.player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.feststelltaste.notrick.api.game.Play;

public class PlayerScoreTest {

    @Test
    public void canSaveScores() {
        PlayerScore playerScore = new PlayerScore();
        Play play1 = new PlayStub();
        Play play2 = new PlayStub();

        playerScore.addScore(play1.round(), 1);
        playerScore.addScore(play2.round(), 1);
        playerScore.addScore(play1.round(), 1);

        assertEquals(2, playerScore.getScore(play1));
        assertEquals(1, playerScore.getScore(play2));
    }

}
