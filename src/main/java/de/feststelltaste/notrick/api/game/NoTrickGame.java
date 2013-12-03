package de.feststelltaste.notrick.api.game;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.feststelltaste.notrick.api.player.Players;

public class NoTrickGame {

    private List<Play> plays = new LinkedList<Play>();
    private Iterator<Play> playIterator;

    public NoTrickGame(Players players) {
        plays.add(new NoTrickPlay(players));
        this.playIterator = plays.iterator();
    }

    public boolean hasFinished() {
        return !playIterator.hasNext();
    }

    public void nextRound() {
       Play currentPlay = playIterator.next();
       currentPlay.start();
    }

}
