package de.feststelltaste.notrick.api.player.ai;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public interface Brain {

    public Card decide(CardSet playedCards, CardSet cardsOnHand);

}
