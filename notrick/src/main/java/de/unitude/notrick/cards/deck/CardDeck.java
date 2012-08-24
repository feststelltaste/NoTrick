package de.unitude.notrick.cards.deck;

import java.util.List;

import de.unitude.notrick.cards.card.Card;

public interface CardDeck {

    List<Card> getAsList();

    int getDeckSize();

    boolean hasCards();

    Card nextCard();

    List<Card> nextCards(int numberOfCards);

    int numberOfTypes();

    int numberOfSuits();

}
