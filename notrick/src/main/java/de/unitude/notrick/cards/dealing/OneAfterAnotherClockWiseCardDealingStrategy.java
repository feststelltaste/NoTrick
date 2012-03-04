package de.unitude.notrick.cards.dealing;

import java.util.Iterator;
import java.util.List;

import de.unitude.notrick.player.Hand;
import de.unitude.notrick.player.Player;

public class OneAfterAnotherClockWiseCardDealingStrategy implements
	CardDealingStrategy {

    private List<Hand> hands;
    private List<Player> players;

    public OneAfterAnotherClockWiseCardDealingStrategy(List<Hand> hands,
	    List<Player> players) {
	this.hands = hands;
	this.players = players;
    }

    @Override
    public void deal() {
	Iterator<Hand> handsIterator = hands.iterator();

	for (Player player : players) {
	    player.take(handsIterator.next());
	}
    }

}
