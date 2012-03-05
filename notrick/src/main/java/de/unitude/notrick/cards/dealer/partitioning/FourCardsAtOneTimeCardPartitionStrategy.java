package de.unitude.notrick.cards.dealer.partitioning;

import java.util.List;

import de.unitude.notrick.cards.deck.CardDeck;
import de.unitude.notrick.player.Hand;

public class FourCardsAtOneTimeCardPartitionStrategy implements
	CardPartitionStrategy {

    private CardDeck cardDeck;
    private List<Hand> hands;
    private static final int FOUR_CARDS = 4;

    public FourCardsAtOneTimeCardPartitionStrategy(CardDeck cardDeck,
	    List<Hand> hands) {
	this.cardDeck = cardDeck;
	this.hands = hands;
    }

    int computeNext(int cardIndex) {
	int cardsPerIteration = hands.size() * FOUR_CARDS;
	return (cardIndex % cardsPerIteration) / FOUR_CARDS;
    }

    @Override
    public void part() {
	for (int cardIndex = 0; cardDeck.hasCards(); cardIndex++) {
	    int handIndex = computeNext(cardIndex);
	    Hand currentHand = hands.get(handIndex);
	    currentHand.add(cardDeck.nextCard());
	}
    }

}
