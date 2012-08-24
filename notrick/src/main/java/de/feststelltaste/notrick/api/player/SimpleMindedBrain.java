package de.feststelltaste.notrick.api.player;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.rules.MustPlaySameSuitIfAvailableRule;
import de.feststelltaste.notrick.api.table.CardTable;

public class SimpleMindedBrain {

    private MustPlaySameSuitIfAvailableRule noTrickRule;

    public SimpleMindedBrain(Hand hand) {
	this.noTrickRule = new MustPlaySameSuitIfAvailableRule(hand.getAllCards());
    }

    Card decide(CardTable cardTable) {
	List<Card> playableCards = noTrickRule.getPlayableCards(cardTable);
	Card alwaysTheFirstCardThatFits = playableCards.get(0);
	return alwaysTheFirstCardThatFits;
    }

}
