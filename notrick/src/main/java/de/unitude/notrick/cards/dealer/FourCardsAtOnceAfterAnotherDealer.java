package de.unitude.notrick.cards.dealer;

import java.util.List;

import de.unitude.notrick.cards.dealer.dealing.CardDealingStrategy;
import de.unitude.notrick.cards.dealer.dealing.OneAfterAnotherClockWiseCardDealingStrategy;
import de.unitude.notrick.cards.dealer.partitioning.CardPartitionStrategy;
import de.unitude.notrick.cards.dealer.partitioning.SpecificNumberOfCardsAtOneTimePartitionStrategy;
import de.unitude.notrick.cards.deck.CardDeck;
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
	CardPartitionStrategy cardPartitioning = new SpecificNumberOfCardsAtOneTimePartitionStrategy(
		cardDeck, 4);
	CardDealingStrategy dealingStrategy = new OneAfterAnotherClockWiseCardDealingStrategy(players, cardPartitioning);
	dealingStrategy.deal();

    }

}
