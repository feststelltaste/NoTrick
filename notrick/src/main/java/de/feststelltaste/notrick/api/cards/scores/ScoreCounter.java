package de.feststelltaste.notrick.api.cards.scores;

import de.feststelltaste.notrick.api.cards.card.CardSet;

public interface ScoreCounter {

    public int determine(CardSet cards);

}
