package de.feststelltaste.notrick.api.cards.card.type;

public enum FrenchType implements Type {

    ACE("ace", 0), KING("king", 1), QUEEN("queen", 2), JACK("jack", 3), TEN("ten", 4), NINE("nine", 5), EIGTH("eigth",
	    6), SEVEN("seven", 7), SIX("six", 8), FIVE("five", 9), FOUR("four", 10), THREE("three", 11), TWO("two", 12);

    private String name;
    private int priority;

    private FrenchType(String name, int priority) {
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
