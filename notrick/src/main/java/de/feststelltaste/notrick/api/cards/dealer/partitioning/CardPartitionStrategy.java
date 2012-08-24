package de.feststelltaste.notrick.api.cards.dealer.partitioning;

import java.util.List;

import de.feststelltaste.notrick.api.cards.card.Card;

public interface CardPartitionStrategy {

    public List<Card> nextPart();

    public boolean hasCards();

}
