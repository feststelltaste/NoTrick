package de.feststelltaste.notrick.api.rules;

import java.util.ArrayList;
import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;

public abstract class RuleSet {

    protected List<Rule> rules = new ArrayList<Rule>();

    public List<Card> follow(List<Card> alreadyPlayedCards, CardSet cardsOnHand) {
	List<Card> cardsAllowedToPlay = cardsOnHand.asList();
	for (Rule rule : rules) {
	    cardsAllowedToPlay = rule.getPlayableCards(alreadyPlayedCards, cardsAllowedToPlay);
	}
	return cardsAllowedToPlay;
    }
}
