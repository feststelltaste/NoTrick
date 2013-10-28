package de.feststelltaste.notrick.api.cards.scores;

import java.util.HashMap;
import java.util.Map;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.card.suit.Suit;
import de.feststelltaste.notrick.api.cards.card.type.Type;

public class ExpertScorer implements ScoreCounter {

    private boolean addAllScores;
    private Map<Card, Integer> scorePerCard = new HashMap<Card, Integer>();
    private Map<Suit, Integer> scorePerSuit = new HashMap<Suit, Integer>();
    private Map<Type, Integer> scorePerType = new HashMap<Type, Integer>();

    public ExpertScorer() {
	this(false);
    }

    public ExpertScorer(boolean b) {
	// TODO Auto-generated constructor stub
    }

    public void add(Card card, int score) {
	this.scorePerCard.put(card, Integer.valueOf(score));
    }

    public void add(Suit suit, int score) {
	this.scorePerSuit.put(suit, Integer.valueOf(score));
    }

    public void add(Type type, int score) {
	this.scorePerType.put(type, Integer.valueOf(score));
    }

    @Override
    public int determine(CardSet cards) {
	int score = 0;
	for (Card card : cards) {
	    if (scorePerCard.containsKey(card)) {
		score += scorePerCard.get(card);
		if (!addAllScores) {
		    continue;
		}
	    }
	    if (scorePerSuit.containsKey(card.getSuit())) {
		score += scorePerSuit.get(card.getSuit());
		if (!addAllScores) {
		    continue;
		}
	    }
	    if (scorePerType.containsKey(card.getType())) {
		score += scorePerType.get(card.getType());
		if (!addAllScores) {
		    continue;
		}
	    }
	}
	return score;
    }

}
