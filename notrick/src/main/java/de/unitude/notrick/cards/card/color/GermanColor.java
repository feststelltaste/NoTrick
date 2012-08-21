package de.unitude.notrick.cards.card.color;

public enum GermanColor implements Color {

    EICHEL("Eichel", 0), GRUEN("Grün", 1), HERZ("Herz", 2), SCHELLEN("Schellen", 3);

    private String name;
    private int priority;

    private GermanColor(String name, int priority) {
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
