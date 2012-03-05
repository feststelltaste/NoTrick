package de.unitude.notrick.table;

import java.util.List;

import de.unitude.notrick.cards.card.Card;

public interface CardTable {

    void add(Card card);

    List<Card> get();

}
