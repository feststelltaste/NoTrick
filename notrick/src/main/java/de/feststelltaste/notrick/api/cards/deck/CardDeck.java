package de.feststelltaste.notrick.api.cards.deck;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public interface CardDeck {

    List<Card> asList();

    int getDeckSize();

    boolean hasCards();

    Card nextCard();

    CardSet nextCards(int numberOfCards);

    int numberOfTypes();

    int numberOfSuits();

}
