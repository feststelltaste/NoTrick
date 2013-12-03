package de.feststelltaste.notrick.api.cards.dealer.dealing;

import de.feststelltaste.notrick.api.cards.dealer.partitioning.CardPartitionStrategy;
import de.feststelltaste.notrick.api.player.Player;
import de.feststelltaste.notrick.api.player.Players;

public class OneAfterAnotherClockWiseCardDealingStrategy implements CardDealingStrategy {

    private Players players;
    private int counter;
    private CardPartitionStrategy cardPartitioning;

    public OneAfterAnotherClockWiseCardDealingStrategy(Players players,
            CardPartitionStrategy cardPartitioning) {
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
