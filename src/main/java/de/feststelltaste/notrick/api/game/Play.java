package de.feststelltaste.notrick.api.game;


public abstract class Play {

    protected final String nameOfPlay;
    
    public Play(String nameOfPlay) {
        this.nameOfPlay = nameOfPlay;
    }

    public abstract void start();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nameOfPlay == null) ? 0 : nameOfPlay.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Play other = (Play) obj;
        if (nameOfPlay == null) {
            if (other.nameOfPlay != null)
                return false;
        } else if (!nameOfPlay.equals(other.nameOfPlay))
            return false;
        return true;
    }

}
