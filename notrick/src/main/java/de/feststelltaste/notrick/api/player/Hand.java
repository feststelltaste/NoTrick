package de.feststelltaste.notrick.api.player;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.sorting.CardSortingStrategy;
import de.feststelltaste.notrick.api.cards.sorting.LowestPriorityFirstCardSorter;

public class Hand {

    private int maxCardsOnHand;
    private CardSet cardSet = new CardSet();
    private CardSortingStrategy sorter = new LowestPriorityFirstCardSorter();

    public Hand(int maxCardsOnHand) {
	this.maxCardsOnHand = maxCardsOnHand;
    }

    public void add(Card card) {
	addToCardSet(card);
	sort();
    }

    private void sort() {
	this.cardSet = sorter.sort(cardSet);
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
	for (Card card : additionalCardSet) {
	    addToCardSet(card);
	}
	sort();
    }
    
    private void addToCardSet(Card card){
	if(this.cardSet.size() + 1 > maxCardsOnHand)
	    throw new TooManyCardsForHandException();
	
	this.cardSet.add(card);
    }

}
