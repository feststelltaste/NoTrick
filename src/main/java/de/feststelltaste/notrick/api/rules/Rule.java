package de.feststelltaste.notrick.api.rules;

import de.feststelltaste.notrick.api.cards.card.CardSet;

public interface Rule {

    public CardSet getPlayableCards(CardSet alreadyPlayedCards, CardSet cardsAllowedToPlay);

}
