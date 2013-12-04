package de.feststelltaste.notrick.api.player;

import de.feststelltaste.notrick.api.game.Play;

public class PlayStub extends Play {

    public PlayStub(int roundOfCurrentPlay) {
        super(roundOfCurrentPlay);
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("I'm just a stub!");
    }

}
