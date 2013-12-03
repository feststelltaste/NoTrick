package de.feststelltaste.notrick.api.cards.scores;

import de.feststelltaste.notrick.api.cards.card.CardSet;

public interface ScoreKeeper {

    public int determine(CardSet cards);

}
