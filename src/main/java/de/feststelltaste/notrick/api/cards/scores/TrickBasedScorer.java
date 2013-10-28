package de.feststelltaste.notrick.api.cards.scores;

import de.feststelltaste.notrick.api.cards.card.CardSet;

public class TrickBasedScorer implements ScoreCounter {

    @Override
    public int determine(CardSet cards) {
	return cards.size();
    }

}
