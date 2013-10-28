package de.feststelltaste.notrick.api.cards.sorting;

import de.feststelltaste.notrick.api.cards.card.CardSet;

public interface CardSortingStrategy {
	
	public CardSet sort(CardSet unsortedCardSet);

}