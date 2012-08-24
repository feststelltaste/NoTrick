package de.feststelltaste.notrick.api.cards.card;

import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.card.type.Type;

public class Card {

    private Suit suit;
    private Type type;

    public Card(Suit suit, Type type) {
	this.suit = suit;
	this.type = type;
    }

    public Suit getSuit() {
	return suit;
    }

    public String getName() {
	return suit.getName() + type.getName().toLowerCase();
    }

    public Type getType() {
	return type;
    }

    @Override
    public String toString() {
	return suit.getPriority() + ":" + type.getPriority() + ": " + getName();
    }

}