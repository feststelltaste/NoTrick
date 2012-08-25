package de.feststelltaste.notrick.api.cards.card;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CardSet implements Iterable<Card> {

    private Set<Card> cards;

    public CardSet() {
	this.cards = new TreeSet<Card>();
    }

    public CardSet(Collection<Card> cardsAsList) {
	this.cards = new TreeSet<Card>(cardsAsList);
    }

    public void add(Card card) {
	cards.add(card);
    }

    public boolean has(Card queenOfHearts) {
	return cards.contains(queenOfHearts);
    }

    @Override
    public Iterator<Card> iterator() {
	return cards.iterator();
    }

    public List<Card> asList() {
	return Arrays.asList(cards.toArray(new Card[0]));
    }

    public int size() {
	return cards.size();
    }

}
