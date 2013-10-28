package de.feststelltaste.notrick.api.cards.deck;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public interface CardDeck {

    public List<Card> asList();

    public int getDeckSize();

    public boolean hasCards();

    public Card nextCard();

    public CardSet nextCards(int numberOfCards);

    public int numberOfTypes();

    public int numberOfSuits();

}
