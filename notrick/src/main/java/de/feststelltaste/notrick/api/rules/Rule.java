package de.feststelltaste.notrick.api.rules;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.table.CardTable;

public interface Rule {

    public List<Card> getPlayableCards(CardTable c);

}
