package de.feststelltaste.notrick.api.scoring;

import de.feststelltaste.notrick.api.cards.card.CardSet;

/**
 * A simple score counter that counts one point for each card in a given card
 * set.
 */
public class PerTrickScorerKeeper implements ScoreKeeper {

    @Override
    public int determine(CardSet cards) {
        return cards.size();
    }

}
