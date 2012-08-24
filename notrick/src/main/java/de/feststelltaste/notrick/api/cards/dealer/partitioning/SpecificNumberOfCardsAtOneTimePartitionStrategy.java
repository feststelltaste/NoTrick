package de.feststelltaste.notrick.api.cards.dealer.partitioning;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.deck.CardDeck;

public class SpecificNumberOfCardsAtOneTimePartitionStrategy implements CardPartitionStrategy {

    private CardDeck cardDeck;
    private int numberOfCardsToPartition;

    public SpecificNumberOfCardsAtOneTimePartitionStrategy(CardDeck cardDeck, int numberOfCardsToPartition) {
	this.cardDeck = cardDeck;
	this.numberOfCardsToPartition = numberOfCardsToPartition;
    }

    @Override
    public List<Card> nextPart() {
	return cardDeck.nextCards(numberOfCardsToPartition);
    }

    @Override
    public boolean hasCards() {
	return cardDeck.hasCards();
    }

}
