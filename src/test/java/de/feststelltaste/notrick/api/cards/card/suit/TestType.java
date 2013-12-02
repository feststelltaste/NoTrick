package de.feststelltaste.notrick.api.cards.card.suit;

import de.feststelltaste.notrick.api.cards.card.type.Type;

public enum TestType implements Type {

    ONE("one", 0), TWO("two", 1), THREE("three", 2);

    private String name;
    private int priority;

    private TestType(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

}