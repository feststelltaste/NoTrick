package de.feststelltaste.notrick.api.player.ai;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.player.Hand;
import de.feststelltaste.notrick.api.table.CardTable;

public interface Brain {

    public Card decide(CardTable cardTable, Hand hand);

}
