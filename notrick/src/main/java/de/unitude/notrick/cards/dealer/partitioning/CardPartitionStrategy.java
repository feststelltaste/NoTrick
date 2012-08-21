package de.unitude.notrick.cards.dealer.partitioning;

import java.util.List;

import de.unitude.notrick.cards.card.Card;

public interface CardPartitionStrategy {

    List<Card> nextPart();

    boolean hasCards();

}
