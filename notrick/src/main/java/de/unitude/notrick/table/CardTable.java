package de.unitude.notrick.table;

import java.util.ArrayList;
import java.util.List;

import de.unitude.notrick.cards.card.Card;

public class CardTable {

    List<Card> cardsOnTable = new ArrayList<Card>();

    public void add(Card card) {
	cardsOnTable.add(card);
    }

    public List<Card> get() {
	return cardsOnTable;
    }
}
