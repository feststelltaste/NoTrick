package de.feststelltaste.notrick.api.cards.dealer.partitioning;

import de.feststelltaste.notrick.api.cards.card.CardSet;

public interface CardPartitionStrategy {

    public CardSet nextPart();

    public boolean hasCards();

}
