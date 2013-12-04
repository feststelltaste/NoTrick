package de.feststelltaste.notrick.api.player;

import java.util.LinkedHashMap;
import java.util.Map;

import de.feststelltaste.notrick.api.game.Play;

class PlayerScore {

    private Map<Integer, Integer> scoresPerPlay = new LinkedHashMap<Integer, Integer>();
    private int overAllScore;
    private int scoreForCurrentPlay;

    public void addScore(int roundOfCurrentPlay, int currentScore) {
        if (!scoresPerPlay.containsKey(roundOfCurrentPlay)) {
            scoresPerPlay.put(roundOfCurrentPlay, Integer.valueOf(0));
            scoreForCurrentPlay = 0;
        }
        Integer existingScoreForPlay = scoresPerPlay.get(roundOfCurrentPlay);
        Integer newScoreForPlay = Integer.valueOf(existingScoreForPlay + currentScore);
        scoresPerPlay.put(roundOfCurrentPlay, newScoreForPlay);
        
        overAllScore += currentScore;
        scoreForCurrentPlay += currentScore;
    }

    public int getScore(Play play) {
        return scoresPerPlay.get(play.round()).intValue();
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
