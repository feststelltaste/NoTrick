package de.feststelltaste.notrick.api.player;

import java.util.LinkedHashMap;
import java.util.Map;

import de.feststelltaste.notrick.api.game.Play;

public class PlayerScore {

    // TODO refactor Play to round number
    private Map<Play, Integer> scoresPerPlay = new LinkedHashMap<Play, Integer>();
    private int overAllScore;
    private int scoreForCurrentPlay;

    public void addScore(Play play, int currentScore) {
        if (!scoresPerPlay.containsKey(play)) {
            scoresPerPlay.put(play, Integer.valueOf(0));
            scoreForCurrentPlay = 0;
        }
        Integer existingScoreForPlay = scoresPerPlay.get(play);
        Integer newScoreForPlay = Integer.valueOf(existingScoreForPlay + currentScore);
        scoresPerPlay.put(play, newScoreForPlay);
        
        overAllScore += currentScore;
        scoreForCurrentPlay += currentScore;
    }

    public int getScore(Play play) {
        return scoresPerPlay.get(play).intValue();
    }

    @Override
    public String toString() {
        return scoresPerPlay.values().toString();
    }
    
    public int getOverallScore() {
        return overAllScore;
    }

    public int getCurrentScore() {
        return scoreForCurrentPlay;
    }

}
