package de.feststelltaste.notrick.api.rules;

import java.util.ArrayList;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;

public abstract class RuleSet {

    protected List<Rule> rules = new ArrayList<Rule>();

    public List<Card> follow(List<Card> alreadyPlayedCards, List<Card> cardsOnHand) {
	List<Card> cardsAllowedToPlay = cardsOnHand;
	for (Rule rule : rules) {
	    cardsAllowedToPlay = rule.getPlayableCards(alreadyPlayedCards, cardsAllowedToPlay);
	}
	return cardsAllowedToPlay;
    }
}
