package de.feststelltaste.notrick.api.rules;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;

public interface Rule {

    public List<Card> getPlayableCards(List<Card> alreadyPlayedCards, List<Card> cardsAllowedToPlay);

}
