package de.unitude.notrick.player;

import java.util.ArrayList;
import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.card.color.Hand;
import de.unitude.notrick.rules.MustPlaySameColorAsFirstCardRule;
import de.unitude.notrick.table.CardTable;

public class Brain {

    private Hand hand;
    private MustPlaySameColorAsFirstCardRule noTrickRules;
    private List<Card> playedCards = new ArrayList<Card>();

    public Brain(Hand hand) {
	this.hand = hand;
	this.noTrickRules = new MustPlaySameColorAsFirstCardRule(
		hand.getAllCards());
    }

    Card decide(CardTable cardTable) {
	List<Card> playableCards = noTrickRules.getPlayableCards(cardTable);
	Card firstCard = playableCards.get(0);
	return firstCard;
    }

    void memorize(List<Card> currentCards) {
	playedCards.addAll(currentCards);

    }

}
