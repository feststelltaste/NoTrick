package de.feststelltaste.notrick.api.cards.dealer;

import de.feststelltaste.notrick.api.cards.dealer.dealing.CardDealingStrategy;
import de.feststelltaste.notrick.api.cards.dealer.dealing.OneAfterAnotherClockWiseCardDealingStrategy;
import de.feststelltaste.notrick.api.cards.dealer.partitioning.CardPartitionStrategy;
import de.feststelltaste.notrick.api.cards.dealer.partitioning.SpecificNumberOfCardsAtOneTimePartitionStrategy;
import de.feststelltaste.notrick.api.cards.deck.CardDeck;
import de.feststelltaste.notrick.api.player.Players;

public class FourCardsAtOnceAfterAnotherDealer implements Dealer {

    private final CardDeck cardDeck;
    private final Players players;

    public FourCardsAtOnceAfterAnotherDealer(CardDeck cardDeck, Players players) {
        this.cardDeck = cardDeck;
        this.players = players;
    }

    @Override
    public void deal() {
        CardPartitionStrategy cardPartitioning = new SpecificNumberOfCardsAtOneTimePartitionStrategy(
                cardDeck, 4);
        CardDealingStrategy dealingStrategy = new OneAfterAnotherClockWiseCardDealingStrategy(
                players, cardPartitioning);
        dealingStrategy.deal();

    }

}
