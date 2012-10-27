package de.feststelltaste.notrick.api.cards.dealer.dealing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.feststelltaste.notrick.api.cards.TestCard;
import de.feststelltaste.notrick.api.cards.card.Card;
import de.feststelltaste.notrick.api.cards.card.type.FrenchType;
import de.feststelltaste.notrick.api.cards.dealer.partitioning.CardPartitionStrategy;
import de.feststelltaste.notrick.api.cards.dealer.partitioning.SpecificNumberOfCardsAtOneTimePartitionStrategy;
import de.feststelltaste.notrick.api.cards.deck.FrenchShortCardDeck;
import de.feststelltaste.notrick.api.cards.deck.TestCardDeck;
import de.feststelltaste.notrick.api.player.Player;

public class OneAfterAnotherClockWiseCardDealingStrategyTest {

    @Test
    public void testDeal() {
	Player firstPlayer = new Player("first");
	Player secondPlayer = new Player("second");

	List<Player> players = new ArrayList<Player>();
	players.add(firstPlayer);
	players.add(secondPlayer);

	TestCardDeck f = new TestCardDeck();

	CardPartitionStrategy cardPartitioning = new SpecificNumberOfCardsAtOneTimePartitionStrategy(f, 1);
	OneAfterAnotherClockWiseCardDealingStrategy dealingStrategy = new OneAfterAnotherClockWiseCardDealingStrategy(
		players, cardPartitioning);
	dealingStrategy.deal();

	assertEquals(TestCard.A1, firstPlayer.showCards().asList().get(0));
	assertEquals(TestCard.A2, secondPlayer.showCards().asList().get(0));
	Card lastCardOfFirstPlayer = firstPlayer.showCards().asList().get(firstPlayer.showCards().asList().size()-1);
	assertEquals(TestCard.B2, lastCardOfFirstPlayer);
	Card lastCardOfSecondPlayer = secondPlayer.showCards().asList().get(secondPlayer.showCards().asList().size()-1);
	assertEquals(TestCard.B3, lastCardOfSecondPlayer);
    }

}
