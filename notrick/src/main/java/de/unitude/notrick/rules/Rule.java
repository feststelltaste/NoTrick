package de.unitude.notrick.rules;

import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.table.CardTable;

public interface Rule {

    public List<Card> getPlayableCards(CardTable c);

}
