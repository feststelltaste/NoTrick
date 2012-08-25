package de.feststelltaste.notrick.api.cards.dealer.dealing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.card.type.FrenchType;
import de.feststelltaste.notrick.api.cards.dealer.dealing.OneAfterAnotherClockWiseCardDealingStrategy;
import de.feststelltaste.notrick.api.cards.dealer.partitioning.CardPartitionStrategy;
import de.feststelltaste.notrick.api.cards.dealer.partitioning.SpecificNumberOfCardsAtOneTimePartitionStrategy;
import de.feststelltaste.notrick.api.cards.deck.FrenchShortCardDeck;
import de.feststelltaste.notrick.api.player.Player;

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
	OneAfterAnotherClockWiseCardDealingStrategy dealingStrategy = new OneAfterAnotherClockWiseCardDealingStrategy(
		players, cardPartitioning);
	dealingStrategy.deal();

	assertEquals(FrenchType.ACE, firstPlayer.showCards().asList().get(0).getType());
	assertEquals(FrenchType.KING, secondPlayer.showCards().asList().get(0).getType());
	assertEquals(FrenchType.EIGTH, firstPlayer.showCards().asList().get(7).getType());
	assertEquals(FrenchType.SEVEN, secondPlayer.showCards().asList().get(7).getType());
    }

}
