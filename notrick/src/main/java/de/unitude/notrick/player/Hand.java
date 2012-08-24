package de.unitude.notrick.player;

import java.util.ArrayList;
import java.util.List;

import de.unitude.notrick.cards.card.Card;
import de.unitude.notrick.cards.sorting.CardSorter;

public class Hand {

    private int maxCardsOnHand;
    private List<Card> cardsOnHand = new ArrayList<Card>();

    public Hand(int maxCardsOnHand) {
	this.maxCardsOnHand = maxCardsOnHand;
    }

    public void add(Card card) {
	cardsOnHand.add(card);
	if (cardsOnHand.size() == maxCardsOnHand) {
	    CardSorter.sortLowestPriorityFirst(cardsOnHand);
	}
    }

    public List<Card> getAllCards() {
	return cardsOnHand;
    }

    public int size() {
	return cardsOnHand.size();
    }

}
