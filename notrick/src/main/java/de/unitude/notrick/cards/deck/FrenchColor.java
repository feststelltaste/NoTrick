package de.unitude.notrick.cards.deck;

import de.unitude.notrick.cards.card.color.Color;

public enum FrenchColor implements Color {

    CLUB("club", 0), DIAMOND("diamond", 1), HEART("heat", 2), SPADES("Spades",
	    3);

    private String name;
    private int priority;

    private FrenchColor(String name, int priority) {
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
