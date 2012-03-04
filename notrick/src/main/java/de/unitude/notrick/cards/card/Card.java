package de.unitude.notrick.cards.card;

import de.unitude.notrick.cards.card.color.Color;
import de.unitude.notrick.cards.card.type.Type;

public class Card {

    private Color color;
    private Type type;

    public Card(Color color, Type type) {
	this.color = color;
	this.type = type;
    }

    public Color getColor() {
	return color;
    }

    public String getName() {
	return color.getName() + type.getName().toLowerCase();
    }

    public Type getType() {
	return type;
    }

    @Override
    public String toString() {
	return (type.getPriority() + color.getPriority() * 8) + 1 + ": "
		+ getName();
    }

}