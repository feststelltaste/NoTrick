package de.unitude.notrick.cards.dealer.dealing;

import java.util.ArrayList;
import java.util.List;

import de.unitude.notrick.cards.dealer.CardDealingStrategy;
import de.unitude.notrick.cards.dealer.Dealer;
import de.unitude.notrick.cards.dealer.partitioning.CardPartitionStrategy;
import de.unitude.notrick.cards.dealer.partitioning.FourCardsAtOneTimeCardPartitionStrategy;
import de.unitude.notrick.cards.deck.CardDeck;
import de.unitude.notrick.player.Hand;
import de.unitude.notrick.player.Player;

public class FourCardsAtOnceAfterAnotherDealer implements Dealer {

    private CardDeck cardDeck;
    private List<Player> players;

    public FourCardsAtOnceAfterAnotherDealer(CardDeck cardDeck,
	    List<Player> players) {
	this.cardDeck = cardDeck;
	this.players = players;
    }

    @Override
    public void deal() {
	List<Hand> hands = initializeHands(cardDeck.getDeckSize()
		/ players.size());

	CardPartitionStrategy cardPartitioning = new FourCardsAtOneTimeCardPartitionStrategy(
		cardDeck, hands);
	cardPartitioning.part();

	CardDealingStrategy dealingStrategy = new OneAfterAnotherClockWiseCardDealingStrategy(
		hands, players);
	dealingStrategy.deal();

    }

    private List<Hand> initializeHands(int size) {
	List<Hand> hands = new ArrayList<Hand>();

	for (int i = 0; i < size; i++) {
	    Hand hand = new Hand(size);
	    hands.add(hand);
	}

	return hands;

    }

}
