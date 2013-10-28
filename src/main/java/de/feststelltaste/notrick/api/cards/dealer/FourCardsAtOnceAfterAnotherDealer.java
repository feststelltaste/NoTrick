package de.feststelltaste.notrick.api.cards.dealer;

import java.util.List;

import de.feststelltaste.notrick.api.cards.dealer.dealing.CardDealingStrategy;
import de.feststelltaste.notrick.api.cards.dealer.dealing.OneAfterAnotherClockWiseCardDealingStrategy;
import de.feststelltaste.notrick.api.cards.dealer.partitioning.CardPartitionStrategy;
import de.feststelltaste.notrick.api.cards.dealer.partitioning.SpecificNumberOfCardsAtOneTimePartitionStrategy;
import de.feststelltaste.notrick.api.cards.deck.CardDeck;
import de.feststelltaste.notrick.api.player.Player;

public class FourCardsAtOnceAfterAnotherDealer implements Dealer {

    private CardDeck cardDeck;
    private List<Player> players;

    public FourCardsAtOnceAfterAnotherDealer(CardDeck cardDeck, List<Player> players) {
	this.cardDeck = cardDeck;
	this.players = players;
    }

    @Override
    public void deal() {
	CardPartitionStrategy cardPartitioning = new SpecificNumberOfCardsAtOneTimePartitionStrategy(cardDeck, 4);
	CardDealingStrategy dealingStrategy = new OneAfterAnotherClockWiseCardDealingStrategy(players, cardPartitioning);
	dealingStrategy.deal();

    }

}
