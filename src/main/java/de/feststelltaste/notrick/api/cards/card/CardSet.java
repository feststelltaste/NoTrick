package de.feststelltaste.notrick.api.cards.card;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.suit.Suit;

public class CardSet implements Iterable<Card> {

    private Collection<Card> cards = new LinkedList<Card>();

    public CardSet() {
    }

    public CardSet(Collection<Card> cardsAsList) {
	this.cards.addAll(cardsAsList);
    }

    public void add(Card card) {
	cards.add(card);
    }

    public boolean has(Card card) {
	return cards.contains(card);
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

    public boolean isEmpty() {
	return cards.isEmpty();
    }

    public boolean has(Suit suit) {
	return !filter(suit).isEmpty();
    }

    public CardSet filter(Suit suit) {
	CardSet cardsWithSuit = new CardSet();

	for (Card card : this) {
	    if (card.getSuit() == suit) {
		cardsWithSuit.add(card);
	    }
	}

	return cardsWithSuit;
    }

}