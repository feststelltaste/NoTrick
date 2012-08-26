package de.feststelltaste.notrick.api.cards.card;

import de.feststelltaste.notrick.api.cards.card.suit.Suit;

public enum TestSuit implements Suit {

    A("A", 0), B("B", 1);

    private String name;
    private int priority;

    private TestSuit(String name, int priority) {
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
