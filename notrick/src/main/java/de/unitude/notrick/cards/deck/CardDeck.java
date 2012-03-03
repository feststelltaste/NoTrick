package de.unitude.notrick.cards.deck;

import java.util.List;

import de.unitude.notrick.cards.card.Card;

public interface CardDeck {

	public boolean hasCards();

	public Card nextCard();

	public List<Card> getAsList();

	public int getDeckSize();

}
