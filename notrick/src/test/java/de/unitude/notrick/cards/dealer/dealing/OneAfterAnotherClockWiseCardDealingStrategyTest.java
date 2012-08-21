package de.unitude.notrick.cards.dealer.dealing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.unitude.notrick.cards.card.type.FrenchType;
import de.unitude.notrick.cards.dealer.partitioning.CardPartitionStrategy;
import de.unitude.notrick.cards.dealer.partitioning.SpecificNumberOfCardsAtOneTimePartitionStrategy;
import de.unitude.notrick.cards.deck.FrenchShortCardDeck;
import de.unitude.notrick.player.Player;

public class OneAfterAnotherClockWiseCardDealingStrategyTest {

    @Test
    public void testDeal() {
	Player firstPlayer = new Player("first");
	Player secondPlayer = new Player("second");

	List<Player> players = new ArrayList<Player>();
	players.add(firstPlayer);
	players.add(secondPlayer);

	FrenchShortCardDeck f = new FrenchShortCardDeck();

	CardPartitionStrategy cardPartitioning = new SpecificNumberOfCardsAtOneTimePartitionStrategy(f, 1);
	OneAfterAnotherClockWiseCardDealingStrategy dealingStrategy = new OneAfterAnotherClockWiseCardDealingStrategy(players, cardPartitioning );
	dealingStrategy.deal();

	assertEquals(FrenchType.ACE, firstPlayer.showCards().get(0).getType());
	assertEquals(FrenchType.KING, secondPlayer.showCards().get(0).getType());
	assertEquals(FrenchType.EIGTH, firstPlayer.showCards().get(7).getType());
	assertEquals(FrenchType.SEVEN, secondPlayer.showCards().get(7).getType());
    }

}
