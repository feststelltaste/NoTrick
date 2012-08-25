package de.feststelltaste.notrick.api.cards.card;

import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.card.type.Type;
import de.feststelltaste.notrick.api.cards.sorting.PriorityCardComparator;

public class Card implements Comparable<Card>{

    private Suit suit;
    private Type type;

    public Card(Suit suit, Type type) {
	this.suit = suit;
	this.type = type;
    }

    public Suit getSuit() {
	return suit;
    }

    @Override
    public int hashCode() {
	int hash = 31;
	hash = hash * 17 + (this.type != null ? type.getPriority() : 0);
	hash = hash * 23 + (this.type != null ? suit.getPriority() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Card other = (Card) obj;
	if (suit == null) {
	    if (other.suit != null)
		return false;
	} else if (!suit.equals(other.suit))
	    return false;
	if (type == null) {
	    if (other.type != null)
		return false;
	} else if (!type.equals(other.type))
	    return false;
	return true;
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

    @Override
    public int compareTo(Card o) {
	return -1 * new PriorityCardComparator().compare(this, o);
    }

}