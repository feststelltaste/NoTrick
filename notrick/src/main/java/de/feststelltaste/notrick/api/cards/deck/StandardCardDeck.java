package de.feststelltaste.notrick.api.cards.deck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;

public abstract class StandardCardDeck implements CardDeck {

    protected List<Card> cards;
    protected Iterator<Card> iterator;
    private int decksize;

    public StandardCardDeck(int decksize) {
	this.decksize = decksize;
	cards = new ArrayList<Card>(decksize);
	init();
	iterator = cards.iterator();
    }

    @Override
    public List<Card> getAsList() {
	return cards;
    }

    @Override
    public int getDeckSize() {
	return decksize;
    }

    @Override
    public boolean hasCards() {
	return iterator.hasNext();
    }

    protected abstract void init();

    @Override
    public Card nextCard() {
	return iterator.next();
    }

    @Override
    public List<Card> nextCards(int numberOfCards) {
	int counter = 0;
	List<Card> returnedCards = new ArrayList<Card>();
	while (iterator.hasNext() && numberOfCards > counter) {
	    returnedCards.add(iterator.next());
	    counter++;
	}
	return returnedCards;
    }

}
