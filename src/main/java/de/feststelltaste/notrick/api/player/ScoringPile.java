package de.feststelltaste.notrick.api.player;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.scores.ScoreCounter;

public class ScoringPile {

    private CardSet cards = new CardSet();
    private ScoreCounter score;

    public ScoringPile(ScoreCounter score) {
	this.score = score;
    }

    public void add(CardSet cardSet) {
	for (Card card : cardSet) {
	    add(card);
	}
    }

    public void add(Card card) {
	this.cards.add(card);

    }

    public int countScore() {
	return score.determine(cards);
    }

}
