package de.feststelltaste.notrick.api.cards.card.suit;

public enum GermanSuit implements Suit {

    EICHEL("Eichel", 0), GRUEN("Grün", 1), HERZ("Herz", 2), SCHELLEN("Schellen", 3);

    private String name;
    private int priority;

    private GermanSuit(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPriority() {
        return priority;
    }

}
