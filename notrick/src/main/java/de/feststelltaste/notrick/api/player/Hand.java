package de.feststelltaste.notrick.api.player;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.sorting.CardSorter;

public class Hand {

    private int maxCardsOnHand;
    private CardSet cardSet = new CardSet();

    public Hand(int maxCardsOnHand) {
	this.maxCardsOnHand = maxCardsOnHand;
    }

    public void add(Card card) {
	cardSet.add(card);
	if (cardSet.size() == maxCardsOnHand) {
	    CardSorter.sortLowestPriorityFirst(cardSet);
	}
    }

    public CardSet getAllCards() {
	return cardSet;
    }

    public int size() {
	return cardSet.size();
    }

    public void set(CardSet cardSet) {
	this.cardSet = cardSet;
    }

    public void add(CardSet additionalCardSet) {
	for(Card card : additionalCardSet){
	    this.cardSet.add(card);
	}
    }

}
