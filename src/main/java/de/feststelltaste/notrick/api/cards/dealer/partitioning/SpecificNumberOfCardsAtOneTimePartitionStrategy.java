package de.feststelltaste.notrick.api.cards.dealer.partitioning;

import de.feststelltaste.notrick.api.cards.card.CardSet;
import de.feststelltaste.notrick.api.cards.deck.CardDeck;

public class SpecificNumberOfCardsAtOneTimePartitionStrategy implements CardPartitionStrategy {

    private CardDeck cardDeck;
    private int numberOfCardsToPartition;

    public SpecificNumberOfCardsAtOneTimePartitionStrategy(CardDeck cardDeck,
            int numberOfCardsToPartition) {
        this.cardDeck = cardDeck;
        this.numberOfCardsToPartition = numberOfCardsToPartition;
    }

    @Override
    public CardSet nextPart() {
        return cardDeck.nextCards(numberOfCardsToPartition);
    }

    @Override
    public boolean hasCards() {
        return cardDeck.hasCards();
    }

}
