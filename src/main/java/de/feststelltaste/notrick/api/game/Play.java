package de.feststelltaste.notrick.api.game;

public abstract class Play {

    protected final int roundOfCurrentPlay;

    public Play(int roundOfCurrentPlay) {
        this.roundOfCurrentPlay = roundOfCurrentPlay;
    }

    public abstract void start();

    public int round() {
        return roundOfCurrentPlay;
    }

}
