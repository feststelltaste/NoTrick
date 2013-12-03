package de.feststelltaste.notrick.api.player.ai;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public class LoserBrain implements Brain {

    @Override
    public Card decide(CardSet playedCards, CardSet cardsOnHand) {
        return cardsOnHand.asList().get(0);
    }

}
