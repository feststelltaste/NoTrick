package de.feststelltaste.notrick.api.game;

public abstract class Play {

    private static int roundCounter = 0;
    protected final int roundOfCurrentPlay;

    public Play() {
        this.roundOfCurrentPlay = ++roundCounter;
    }

    public abstract void start();

    public int round() {
        return roundOfCurrentPlay;
    }

}
