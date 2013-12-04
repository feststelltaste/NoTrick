package de.feststelltaste.notrick.api.player.ai;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public interface Ai {

    public Card decide(CardSet playedCards, CardSet cardsOnHand);

}
