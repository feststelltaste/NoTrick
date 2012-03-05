package de.unitude.notrick.table;

import java.util.ArrayList;
import java.util.List;

import de.unitude.notrick.cards.card.Card;

public class LinearCardTable implements CardTable {

    List<Card> cardsOnTable = new ArrayList<Card>();

    public LinearCardTable() {

    }

    @Override
    public void add(Card card) {
	cardsOnTable.add(card);
    }

    @Override
    public List<Card> get() {
	return cardsOnTable;
    }

}
