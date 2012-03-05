package de.unitude.notrick.cards.deck;

import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.Color;
import de.unitude.notrick.cards.card.type.Type;

public interface CardDeck {

    List<Card> getAsList();

    int getDeckSize();

    boolean hasCards();

    Card nextCard();

    List<? extends Type> getTypes();

    List<? extends Color> getColors();

}
