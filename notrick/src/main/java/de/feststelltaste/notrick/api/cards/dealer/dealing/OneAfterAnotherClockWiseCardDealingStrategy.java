package de.feststelltaste.notrick.api.cards.dealer.dealing;

import java.util.List;

import de.feststelltaste.notrick.api.cards.dealer.partitioning.CardPartitionStrategy;
import de.feststelltaste.notrick.api.player.Player;

public class OneAfterAnotherClockWiseCardDealingStrategy implements CardDealingStrategy {

    private List<Player> players;
    private int counter;
    private CardPartitionStrategy cardPartitioning;

    public OneAfterAnotherClockWiseCardDealingStrategy(List<Player> players, CardPartitionStrategy cardPartitioning) {
	this.players = players;
	this.cardPartitioning = cardPartitioning;
    }

    @Override
    public void deal() {
	counter = 0;
	while (cardPartitioning.hasCards()) {
	    nextPlayer().take(cardPartitioning.nextPart());
	}
    }

    private Player nextPlayer() {
	Player nextPlayer = players.get(counter % players.size());
	counter++;
	return nextPlayer;
    }

}
